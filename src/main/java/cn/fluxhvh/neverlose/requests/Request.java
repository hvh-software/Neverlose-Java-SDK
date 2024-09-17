package cn.fluxhvh.neverlose.requests;

import cn.fluxhvh.neverlose.response.BaseResponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Request {
    String url();

    Class<? extends BaseResponse> response() default BaseResponse.class;
}
