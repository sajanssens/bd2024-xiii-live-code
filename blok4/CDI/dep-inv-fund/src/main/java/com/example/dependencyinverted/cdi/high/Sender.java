package com.example.dependencyinverted.cdi.high;

import com.example.dependencyinverted.cdi.util.EMAIL;
import com.example.dependencyinverted.cdi.util.SMS;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static com.example.dependencyinverted.cdi.util.Util.streamOf;
import static java.util.stream.Collectors.joining;

// High level module
@Dependent
public class Sender {

    // Satisfies:
    // 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
    private final List<Sendable> sendables = new ArrayList<>();

    // Dependency Injection -----------------------------

    // 1. field injection
    // - Exactly one Sender bean
    // @Inject /*@EM*/  /*@Named("Email")*/
    private Sendable sendable;

    // - All known Sendable CDI beans
    @Inject @Any
    private Instance<Sendable> sendableCDIBeans;

    // 2. constructor injection
    @Inject /* (Take the Default Sendable) */
    public Sender(Sendable s) { plugin(s); }

    // 3. setter/property injection
    @Inject @Any
    public void setSendable(Sendable s) { plugin(s); }

    // 3. setter/property injection
    @Inject
    public void setSMSSendable(@SMS Sendable s) { plugin(s); }

    // 3. setter/property injection
    @Inject
    public void setEmailSendable(@EMAIL Sendable s) { plugin(s); }

    public void plugin(Sendable s) {
        // Satisfies:
        // 2. Abstractions should not depend on details. Details should depend on abstractions.

        // Inversion of control: new is gone. Let someone else supply the object(s)
        sendables.add(s);
    }

    public String sendAll() {
        return sendables.stream()
                .map(Sendable::send)
                .collect(joining(", "));
    }

    public String sendAllCDIBeans() {
        return streamOf(sendableCDIBeans)
                .map(Sendable::send)
                .collect(joining(", "));
    }

    public <S extends Sendable> String send(Class<S> type) {
        return sendables.stream()
                .filter(s -> s.getClass().equals(type))
                .map(Sendable::send)
                .collect(joining(", "));
    }
}
