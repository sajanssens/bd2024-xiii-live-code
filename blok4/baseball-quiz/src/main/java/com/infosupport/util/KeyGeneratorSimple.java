package com.infosupport.util;

import jakarta.enterprise.context.ApplicationScoped;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@ApplicationScoped
public class KeyGeneratorSimple implements KeyGenerator {

    @Override
    public SecretKey generateKey() {
        byte[] key = "baseball-is-cool!".getBytes();
        return new SecretKeySpec(key, 0, key.length, "DES");
    }
}
