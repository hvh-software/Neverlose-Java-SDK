import cn.fluxhvh.neverlose.requests.impl.CheckUserExistedRequest;

import java.io.IOException;

public class CheckUserExisted {
    public static void main(String[] args) throws IOException {
        System.out.println(new CheckUserExistedRequest("Margele").send());
    }
}
