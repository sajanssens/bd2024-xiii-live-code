package com.infosupport.h7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PersonTest {

    private Person sut;
    private ShoeManager shoeManagerMock;

    @BeforeEach
    void setUp() {
        sut = new Person();
        sut.setFootSize(43);

        shoeManagerMock = mock(ShoeManager.class);

        sut.setShoeManager(shoeManagerMock);
    }

    @Test
    void whenAddIsCalledWithAShoeWithCorrectSizeThenTheShoeIsAdded() {
        // given
        var s = new Shoe(43, "Dr. Martens");
        when(shoeManagerMock.add(any())).thenReturn(true);

        // when
        sut.add(s);

        // then
        verify(shoeManagerMock).add(any());
    }

    @Test
    void find() {
    }
}
