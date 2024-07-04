package com.infosupport.util.importer;

import com.infosupport.domain.ImportDto;
import com.infosupport.util.Json;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "importerMdb")
public class ImporterConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String m = message.getBody(String.class);
            ImportDto importDto = Json.fromJson(m, ImportDto.class);
            System.out.println("Message received: " + importDto);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
