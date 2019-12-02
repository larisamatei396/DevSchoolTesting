package com.ing.tech.devschool.testing.service;

import com.ing.tech.devschool.testing.api.model.Account;
import com.ing.tech.devschool.testing.api.repository.AccountRepository;
import com.ing.tech.devschool.testing.api.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void shouldReturnAnAccount() {
        when(accountRepository.findById(anyLong()))
            .thenReturn(Optional.of(new Account()));

        assertNotNull(accountService.findById(anyLong()));
    }

    @Test
    public void shouldReturnNullWhenAccountNotFound() {
        when(accountRepository.findById(anyLong()))
            .thenReturn(Optional.empty());

        assertNull(accountService.findById(anyLong()));
    }

    @Test
    public void shouldCreateAnAccount() {
        String clientName = "clientName";
        Account expected = Account.builder().clientName(clientName).totalBalance(0.0).build();

        Account actual = accountService.createAccount(clientName);

        verify(accountRepository, times(1)).save(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteAnAccount() {
        String clientName = "clientName";
        Account account = Account.builder().clientName(clientName).totalBalance(0.0).accountNumber(10L).build();

        when(accountRepository.findById(10L)).thenReturn(Optional.of(account));

        boolean result = accountService.deleteIfExists(account.getAccountNumber());

        verify(accountRepository, times(1)).delete(account);
        assertTrue(result);
    }

    @Test
    public void shouldNotDeleteAnAccount() {
        //TODO

    }

}
