package by.grsu.domain;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class TokenGenerator {

    private int token;

    public void generateToken(String userName, String userPassword) throws UnsupportedEncodingException {
        String buffer = userName + userPassword + System.currentTimeMillis();
        token = (Base64.encodeBase64String(buffer.getBytes("UTF-8"))).hashCode();
    }

    public int getToken() {
        return token;
    }
}
