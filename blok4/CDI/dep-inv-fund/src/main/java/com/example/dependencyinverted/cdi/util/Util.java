package com.example.dependencyinverted.cdi.util;

import com.example.dependencyinverted.cdi.high.Sendable;
import jakarta.enterprise.inject.Instance;

import java.util.stream.Stream;

import static java.util.stream.StreamSupport.stream;

public final class Util {
    private Util() { }

    public static final String OK = "OK";

    public static Stream<Sendable> streamOf(Instance<Sendable> sendableInstance) {
        return stream(sendableInstance.spliterator(), false);
    }
}
