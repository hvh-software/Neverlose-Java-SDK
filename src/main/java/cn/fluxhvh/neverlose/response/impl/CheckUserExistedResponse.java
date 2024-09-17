package cn.fluxhvh.neverlose.response.impl;


import cn.fluxhvh.neverlose.response.BaseResponse;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class CheckUserExistedResponse extends BaseResponse {
    @JSONField(name = "user_exists")
    private boolean userExists;
}
