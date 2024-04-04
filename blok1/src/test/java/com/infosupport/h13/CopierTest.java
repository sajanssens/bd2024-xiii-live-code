package com.infosupport.h13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.infosupport.h13.Copier.copy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CopierTest {

    @Test
    void whenIntegersAreCopiedToNumbersTheNumberlistContainsAllTheIntegers() {
        // given
        List<Number> numbers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3));

        // when
        copy(integers, numbers);

        // then
        assertThat(numbers).containsAll(integers);
    }
}
