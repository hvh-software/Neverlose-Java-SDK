package cn.fluxhvh.neverlose;

public class NeverloseSDK {
    public static int userId = System.getProperty("neverlose.userId") == null ? 0 : Integer.parseInt(System.getProperty("neverlose.userId"));
    public static String secret = System.getProperty("neverlose.secret");

    /**
     * Setup the SDK with the user id and secret if you don't want to set them in the system properties.
     */
    public static void setup(int userId, String secret) {
        NeverloseSDK.userId = userId;
        NeverloseSDK.secret = secret;
    }
}
