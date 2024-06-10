package com.infosupport.util;

import com.infosupport.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Questions {
    // DTO: Data Transfer Object, POJO (Plain Old Java Object) to transfer some data

    private List<Question> questions;

    public static Questions of(List<Question> questions) {
        return new Questions(questions);
    }
}
