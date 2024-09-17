import cn.fluxhvh.neverlose.requests.impl.CheckUserExistedRequest;
import cn.fluxhvh.neverlose.response.impl.CheckUserExistedResponse;
import cn.fluxhvh.neverlose.response.BaseResponse;

import java.io.IOException;

public class CheckUserExisted {
    public static void main(String[] args) throws IOException {
        BaseResponse response = new CheckUserExistedRequest("Margele").send();

        if (response instanceof CheckUserExistedResponse) {
            if (((CheckUserExistedResponse) response).isUserExists()) {
                System.out.println("User exists");
            } else {
                System.out.println("User does not exist");
            }
        }
    }
}
