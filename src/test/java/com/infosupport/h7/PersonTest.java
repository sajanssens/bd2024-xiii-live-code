package com.infosupport.h7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
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

    @Test
    void whenBrandStartsWithDrAllShoesWithDrAreFound() {
        // given
        String prefix = "Dr.";
        Shoe s1 = new Shoe(42, prefix + " Martens");
        Shoe s2 = new Shoe(42, prefix + " Martens");
        when(shoeManagerMock.find(startsWith(prefix))).thenReturn(List.of(s1, s2));

        // when
        List<Shoe> shoes = sut.findDr(prefix);

        // then
        assertEquals(2, shoes.size());
        assertEquals(s1, shoes.get(0));
        assertEquals(s2, shoes.get(1));
        verify(shoeManagerMock, times(1)).find(prefix);
    }

    @Test
    void whenBrandDoesntStartWithDrNoShoesAreFound() {
        // when
        List<Shoe> shoes = sut.findDr("prefix");

        // then
        assertEquals(0, shoes.size());
        verify(shoeManagerMock, never()).find(anyString());
    }
}
