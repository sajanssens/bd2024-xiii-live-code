package com.infosupport.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class Json {

    private static final Gson gson = new GsonBuilder().create();

    private Json() { }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }
}
