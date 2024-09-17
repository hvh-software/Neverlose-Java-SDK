package cn.fluxhvh.neverlose.requests;

import cn.fluxhvh.neverlose.NeverloseSDK;
import cn.fluxhvh.neverlose.enums.Products;
import cn.fluxhvh.neverlose.enums.UpgradeType;
import cn.fluxhvh.neverlose.response.BaseResponse;
import cn.fluxhvh.neverlose.utils.NetworkUtils;
import cn.fluxhvh.neverlose.utils.PacketIDUtils;
import cn.fluxhvh.neverlose.utils.SignatureUtils;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@Getter
@ToString
public abstract class BaseRequest {
    @JSONField(serialize = false)
    private String url;

    @JSONField(name = "id")
    private long packetId;

    @JSONField(name = "user_id")
    private int userId;

    @JSONField(name = "signature")
    private String signature;

    protected BaseRequest build() {
        // Get packet url
        if (!this.getClass().isAnnotationPresent(Request.class)) {
            throw new RuntimeException("Request annotation not found");
        }

        Request request = this.getClass().getAnnotation(Request.class);
        this.url = request.url();

        // Set packetId and userId
        this.packetId = PacketIDUtils.generatePacketId();
        this.userId = NeverloseSDK.userId;

        // Generate signature
        Map<String, Object> params = new HashMap<>();
        try {
            // Get all fields
            List<Field> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(this.getClass().getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(this.getClass().getDeclaredFields()));

            // Put all fields with JSONField annotation into params
            for (Field field : fields) {
                if (field.isAnnotationPresent(JSONField.class)) {
                    JSONField annotation = field.getAnnotation(JSONField.class);
                    field.setAccessible(true);
                    Object value = field.get(this);

                    if (!annotation.name().isEmpty() && value != null) {
                        if (value instanceof Products) {
                            value = ((Products) value).getProduct();
                        } else if (value instanceof UpgradeType) {
                            value = ((UpgradeType) value).getValue();
                        }

                        params.put(annotation.name(), value);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate signature", e);
        }

        this.signature = SignatureUtils.generateSignature(params, NeverloseSDK.secret);

        return this;
    }

    public BaseResponse send() throws IOException {
        if (!this.getClass().isAnnotationPresent(Request.class)) {
            throw new RuntimeException("Request annotation not found");
        }
        Request request = this.getClass().getAnnotation(Request.class);

        return NetworkUtils.sendRequest(build(), request.response());
    }
}
