package com.infosupport.domain;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionTest {

    @Test
    void whenQuestionWithAnswersIsMarshalledToJsonUsingTheDefaultJsonbImplementationItIsOk() throws Exception {
        Question question = Question.builder()
                .text("QQQ")
                .answer(Answer.builder().text("AAA").isCorrect(true).build())
                .answer(Answer.builder().text("BBB").isCorrect(false).build())
                .build();

        try (Jsonb jsonb = JsonbBuilder.create()) {
            String json = jsonb.toJson(question);
            System.out.println(json);
            assertTrue(json.contains("QQQ"));
            assertTrue(json.contains("AAA"));
            assertTrue(json.contains("BBB"));
        }
    }
}
