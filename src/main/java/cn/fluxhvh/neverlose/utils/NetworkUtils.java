package cn.fluxhvh.neverlose.utils;

import cn.fluxhvh.neverlose.NeverloseSDK;
import cn.fluxhvh.neverlose.requests.BaseRequest;
import cn.fluxhvh.neverlose.response.BaseResponse;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;

public class NetworkUtils {
    private static final OkHttpClient client;

    static {
        if (NeverloseSDK.debug) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        } else {
            client = new OkHttpClient();
        }
    }

    /**
     * Why I use null as content type:
     * Neverlose check the content type of the request, if it is not application/json, it will return "invalid content type(not application/json)"
     * If you use MediaType.parse("application/json") as content type, it will add charset=utf-8 to the content type, and the content type will be application/json; charset=utf-8
     * So I hope Neverlose can fix this issue
     */
    private static String sendPost(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, null);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
        }

        throw new IOException("Empty response");
    }

    public static <T> T sendRequest(BaseRequest request, Class<T> beans) throws IOException {
        T response = JSON.parseObject(NetworkUtils.sendPost("https://neverlose.cc" + request.getUrl(), JSONObject.toJSONString(request)), beans);

        if (!(response instanceof BaseResponse)) {
            throw new IOException("Invalid response");
        }

        BaseResponse baseResponse = (BaseResponse) response;
        if (!baseResponse.isSuccess()) {
            throw new IOException(baseResponse.getError());
        }

        return response;
    }
}
