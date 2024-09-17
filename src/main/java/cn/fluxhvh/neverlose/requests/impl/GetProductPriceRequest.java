package cn.fluxhvh.neverlose.requests.impl;

import cn.fluxhvh.neverlose.enums.Products;
import cn.fluxhvh.neverlose.requests.BaseRequest;
import cn.fluxhvh.neverlose.requests.Request;
import cn.fluxhvh.neverlose.response.impl.GetProductPriceResponse;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Request(url = "/api/market/get-prices", response = GetProductPriceResponse.class)
public class GetProductPriceRequest extends BaseRequest {
    @JSONField(name = "product", serializeUsing = Products.ProductsSerializer.class)
    private Products product;
}
