package cn.fluxhvh.neverlose.requests.impl;

import cn.fluxhvh.neverlose.requests.BaseRequest;
import cn.fluxhvh.neverlose.requests.Request;
import cn.fluxhvh.neverlose.response.impl.CheckUserExistedResponse;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Request(url = "/api/market/is-user-exists", response = CheckUserExistedResponse.class)
public class CheckUserExistedRequest extends BaseRequest {
    @JSONField(name = "username")
    private String username;
}
