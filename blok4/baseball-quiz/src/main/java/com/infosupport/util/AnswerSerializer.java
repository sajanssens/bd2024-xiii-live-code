package com.infosupport.util;

import com.infosupport.domain.Answer;
import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

import java.util.Set;

public class AnswerSerializer implements JsonbSerializer<Set<Answer>> {
    @Override
    public void serialize(Set<Answer> answers, JsonGenerator json, SerializationContext ctx) {
        json.writeStartArray();
        answers.forEach(a -> {
            json.writeStartObject();
            json.write("text", a.getText());
            json.write("correct", a.isCorrect());
            json.writeEnd();
        });
        json.writeEnd();
    }
}
