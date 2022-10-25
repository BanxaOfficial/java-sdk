package com.banxa.authentication;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Formatter;

public class Authentication {
    private final String apiKey;
    private final String apiSecret;

    public Authentication(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    /**
     * Generate Auth Token
     * @param method
     * @param uri
     * @param payload
     * @return
     * @throws Exception
     */
    public String generateAuthToken(String method, String uri, String payload, long nonce) throws Exception {
        String data = method + "\n" +
                uri + "\n" +
                nonce;

        if (payload != null) {
            data += "\n" + payload;
        }

        SecretKeySpec signingKey = new SecretKeySpec(this.apiSecret.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        return this.apiKey + ":" + toHexString(mac.doFinal(data.getBytes())) + ":" + nonce;
    }

    private String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}
