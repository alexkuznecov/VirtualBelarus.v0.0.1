package by.grsu.domain;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Token {

    private Integer token;

    public void generateToken(String userName, String userEmail) throws UnsupportedEncodingException {
        String buffer = userName + userEmail + System.currentTimeMillis();
        token = (Base64.encodeBase64String(buffer.getBytes("UTF-8"))).hashCode();
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }
}
