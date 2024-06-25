package com.infosupport.domain;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionTest {

    @Test
    void whenQuestionWithBiDirectionalPolymorphicAnswersIsParsedItIsOk() throws Exception {
        Question question = Question.builder()
                .text("QQQ")
                .answer(YesNoAnswer.builder().text("AAA").correct(true).build())
                .answer(MultiChoiceAnswer.builder().text("BBB").correct(false).build())
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
                   "text": "QQQ",
                   "answers": [
                     {
                       "@answer": "yesno",
                       "correct": true,
                       "text": "AAA"
                     },
                     {
                       "@answer": "multi",
                       "correct": false,
                       "text": "BBB"
                     }
                   ]
                 }
                """;

        try (Jsonb jsonb = JsonbBuilder.create()) {
            Question q = jsonb.fromJson(json, Question.class);
            System.out.println(q);
            assertEquals("QQQ", q.getText());
            assertEquals(2, q.getAnswers().size());
        }
    }
}
