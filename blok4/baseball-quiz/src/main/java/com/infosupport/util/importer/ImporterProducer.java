package com.infosupport.util.importer;

import com.infosupport.domain.ImportDto;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;

import static com.infosupport.util.Json.toJson;

// @ApplicationScoped
@Stateless
public class ImporterProducer {

    // @Inject // the JNDI name from JMSDestinationDefinition
    @Resource(lookup = "jms/importer")
    private Queue queue;

    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;

    public void send(ImportDto dto) {
        System.out.println("About to send message: " + dto);
        try (var context = connectionFactory.createContext()) {
            JMSProducer producer = context.createProducer();
            producer.send(queue, toJson(dto));
        }
    }
}
