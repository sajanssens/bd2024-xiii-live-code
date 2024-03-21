package com.infosupport.h7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    @Mock
    private ShoeManager shoeManagerMock;

    @InjectMocks
    private Person sut;

    @BeforeEach
    void setUp() {
        sut.setFootSize(43);
    }

    @Test
    void whenAddIsCalledWithAShoeWithCorrectSizeThenTheShoeIsAdded() {
        // given
        var s = new Shoe(43, "Dr. Martens");
        when(shoeManagerMock.add(any())).thenReturn(true);

        // when
        boolean result = sut.fit(s);

        // then
        assertTrue(result);
        verify(shoeManagerMock).add(any());
    }
}
