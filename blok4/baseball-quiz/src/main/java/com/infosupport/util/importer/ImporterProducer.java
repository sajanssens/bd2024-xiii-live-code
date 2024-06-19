package com.infosupport.util.importer;

import com.infosupport.domain.ImportDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;

import static com.infosupport.util.Json.toJson;

@ApplicationScoped
public class ImporterProducer {

    @Inject // the JNDI name from JMSDestinationDefinition
    private Queue queue;

    @Inject
    private JMSContext context;

    public void send(ImportDto dto) {
        System.out.println("About to send message: " + dto);
        JMSProducer producer = context.createProducer();
        producer.send(queue, toJson(dto));
    }
}
