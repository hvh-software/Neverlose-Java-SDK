package cn.fluxhvh.neverlose.requests.impl;

import cn.fluxhvh.neverlose.requests.BaseRequest;
import cn.fluxhvh.neverlose.requests.Request;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Request(url = "/api/market/transfer-money")
public class TransferBalanceRequest extends BaseRequest {
    @JSONField(name = "username")
    private String username;

    @JSONField(name = "amount")
    private double amount;
}
