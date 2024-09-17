package cn.fluxhvh.neverlose.requests.impl;

import cn.fluxhvh.neverlose.requests.BaseRequest;
import cn.fluxhvh.neverlose.requests.Request;
import cn.fluxhvh.neverlose.response.impl.GetBalanceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Request(url = "/api/market/get-balance", response = GetBalanceResponse.class)
public class GetBalanceRequest extends BaseRequest {
}
