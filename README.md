# Neverlose Marketplace SDK for Java
This SDK is a Java library for interacting with the Neverlose Marketplace API. It allows you to interact with the API in a more convenient way.

## Setup
### Add JVM arguments
```
-Dneverlose.userId=[Your User ID] -Dneverlose.secret=[Your Secret]
```

### Setup method
```Java
import cn.fluxhvh.neverlose.NeverloseSDK;

public class Main {
    public static void main(String[] args) {
        NeverloseSDK.setup("Your User ID", "Your Secret");
    }
}
```

## Usage
```Java
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
```

## Debug
```
-Dneverlose.debug=true
```

## Credits
This SDK is based on the [Neverlose Marketplace API](https://github.com/neverlosecc/marketplace-api) and was created by [Neverlose](https://neverlose.cc/).

Made by Flux-Team with ❤️