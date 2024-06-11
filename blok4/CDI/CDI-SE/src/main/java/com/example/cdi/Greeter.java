package com.example.cdi;

import com.example.cdi.greetings.IGreeting;
import com.example.cdi.greetings.NLGreeting;
import com.example.cdi.greetings.qualifiers.DE;
import com.example.cdi.greetings.qualifiers.EN;
import com.example.cdi.greetings.qualifiers.MaxNumber;
import com.example.cdi.greetings.qualifiers.RandomNumber;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Optional;
import java.util.StringJoiner;

@Dependent
public class Greeter {

    // example of field-injecting a qualified bean
    @Inject @EN IGreeting enGreeting;

    // example of field-injecting a default bean
    @Inject @Default IGreeting defaultGreeting;

    // example of injecting a Provider of a bean, instead of a bean directly
    @Inject @DE Provider<IGreeting> deGreetingProvider;
    @Inject @Default Provider<IGreeting> defaultGreetingProvider;

    // example of injecting any Instance of a bean(s), instead of a bean directly
    @Inject @Any Instance<IGreeting> anyGreetings;

    // example of injecting event
    @Inject @Any Event<Person> personEvent;

    @Inject @MaxNumber
    private int maxNumber;

    @Inject @RandomNumber
    private int randomNumber;

    private final Logger log; // injected by constructor injection

    @Inject // example of constructor injection (of a Logger produced by LoggerProducer)
    public Greeter(Logger log) {
        this.log = log;
    }

    @Inject
    Person special; // new person from PersonProducer

    public String hi() {
        log.info("Hi was called...");

        log.info("Firing person event...");
        fireEvent();

        return getAllGreetings().toString();
    }

    public void fireEvent() {
        personEvent.fire(special);
    }

    private StringJoiner getAllGreetings() {
        final String BRAM = "Bram";
        StringJoiner all = new StringJoiner(" | ");

        String df = defaultGreeting.greet(BRAM);
        String en = enGreeting.greet(BRAM);

        String de = greeting(deGreetingProvider).map(g -> g.greet(BRAM)).orElse("");
        // or imperative style:
        // IGreeting iGreeting = deGreetingProvider.get();
        // String de2 = "";
        // if (iGreeting != null) {
        //     de2 = iGreeting.greet(BRAM);
        // }

        String dfp = greeting(defaultGreetingProvider).map(g -> g.greet(BRAM)).orElse("");

        Instance<NLGreeting> nlGreeting = anyGreetings.select(NLGreeting.class);
        String nl = !nlGreeting.isUnsatisfied() ? nlGreeting.get().greet(BRAM) : "";

        all
                .add("DF:  " + df)
                .add("EN:  " + en)
                .add("NL:  " + nl)
                .add("DE:  " + de)
                .add("DFP: " + dfp);

        for (IGreeting anyGreeting : anyGreetings) {
            all
                    .add("Any: " + anyGreeting.greet(BRAM));
        }
        return all;
    }

    private <T extends IGreeting> Optional<T> greeting(Provider<T> provider) {
        return Optional.of(provider.get());
    }

    public void logNumbers() {
        log.info("maxNumber = " + maxNumber);
        log.info("randomNumber = " + randomNumber);
    }

}
