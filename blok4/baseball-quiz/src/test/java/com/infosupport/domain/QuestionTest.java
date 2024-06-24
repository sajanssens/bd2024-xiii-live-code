package com.infosupport.domain;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionTest {

    @Test
    void whenQuestionWithAnswersIsMarshalledToJsonUsingTheDefaultJsonbImplementationItIsOk() throws Exception {
        Question question = Question.builder()
                .text("QQQ")
                .answer(Answer.builder().text("AAA").correct(true).build())
                .answer(Answer.builder().text("BBB").correct(false).build())
                .build();

        try (Jsonb jsonb = JsonbBuilder.create()) {
            String json = jsonb.toJson(question);
            System.out.println(json);
            assertTrue(json.contains("QQQ"));
            assertTrue(json.contains("AAA"));
            assertTrue(json.contains("BBB"));
        }

        String json = """
                {
                  "text": "Q",
                  "answers": [
                    {
                      "text": "A",
                      "correct": true
                    },
                    {
                      "text": "B",
                      "correct": false
                    }
                  ]
                }
                """;

        try (Jsonb jsonb = JsonbBuilder.create()) {
            Question q = jsonb.fromJson(json, Question.class);
            System.out.println(q);
            assertEquals("Q", q.getText());
            assertEquals(2, q.getAnswers().size());
        }
    }
}
