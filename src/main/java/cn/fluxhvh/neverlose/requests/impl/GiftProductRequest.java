package cn.fluxhvh.neverlose.requests.impl;

import cn.fluxhvh.neverlose.enums.Products;
import cn.fluxhvh.neverlose.enums.UpgradeType;
import cn.fluxhvh.neverlose.requests.BaseRequest;
import cn.fluxhvh.neverlose.requests.Request;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Request(url = "/api/market/gift-product")
public class GiftProductRequest extends BaseRequest {
    @JSONField(name = "username")
    private String username;

    @JSONField(name = "product", serializeUsing = Products.ProductsSerializer.class)
    private Products product;

    @JSONField(name = "cnt", serializeUsing = UpgradeType.UpgradeTypeSerializer.class)
    private UpgradeType type;
}
