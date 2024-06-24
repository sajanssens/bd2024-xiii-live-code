package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Disabled
@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock private EntityManager emMock;
    @Mock private Employee eMock;
    @Mock private EntityTransaction txMock;

    @InjectMocks
    private EmployeeDao sut;

    @Test
    void create_with_happy_flow_begins_and_commits_transaction() {
        // Arrange
        when(emMock.getTransaction()).thenReturn(txMock);
        doNothing().when(txMock).begin();
        doNothing().when(txMock).commit();

        doNothing().when(emMock).persist(eq(eMock));

        // Act
        sut.create(eMock);

        // Assert
        // assertThats

        // verifies
        verify(emMock, times(1)).getTransaction();
        verify(txMock, times(1)).begin();
        verify(txMock, times(1)).commit();
        verify(txMock, never()).rollback();
    }

    @Test
    void create_with_exception_begins_and_rolls_back_transaction() {
        // Arrange
        when(emMock.getTransaction()).thenReturn(txMock);
        doNothing().when(txMock).begin();
        doNothing().when(txMock).rollback();

        doThrow(PersistenceException.class).when(emMock).persist(eq(eMock));

        // Act
        sut.create(eMock);

        // Assert
        // assertThats

        // verifies
        verify(emMock, times(1)).getTransaction();
        verify(txMock, times(1)).begin();
        verify(txMock, never()).commit();
        verify(txMock, times(1)).rollback();
    }
}
