package com.infosupport.util;

import java.security.MessageDigest;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordUtils {

    public static String digest(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainText.getBytes(UTF_8));
            return new String(Base64.getEncoder().encode(md.digest()));
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password.", e);
        }
    }
}
