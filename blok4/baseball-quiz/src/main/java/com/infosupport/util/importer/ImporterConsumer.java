package com.infosupport.util.importer;

import com.infosupport.domain.ImportDto;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(
        name = "ConsumerMDB",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:app/testQueue")
        }
)
public class ImporterConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            ImportDto m = message.getBody(ImportDto.class);
            System.out.println("Message received: " + m);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
