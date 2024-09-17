package cn.fluxhvh.neverlose.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;
import java.util.TreeMap;

public class SignatureUtils {
    public static String generateSignature(Map<String, Object> params, String secret) {
        // Sort the parameters by key
        TreeMap<String, Object> sortedParams = new TreeMap<>(params);

        // Build the string to hash
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedParams.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        sb.append(secret);

        // Compute the SHA-256 hash using Apache Commons Codec
        return DigestUtils.sha256Hex(sb.toString());
    }
}
