package cn.fluxhvh.neverlose.response;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BaseResponse {
    @JSONField(name = "success")
    private boolean success;

    @JSONField(name = "error")
    private String error;
}
