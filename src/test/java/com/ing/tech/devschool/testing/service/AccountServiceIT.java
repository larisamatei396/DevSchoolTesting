package com.ing.tech.devschool.testing.service;

import com.ing.tech.devschool.testing.api.model.Account;
import com.ing.tech.devschool.testing.api.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceIT {

    @Autowired
    private AccountService accountService;

    private long numberOfAccounts = 5L;

    @Test
    public void shouldFindAnAccount() {
        String clientName = "Mihai";
        long clientId = 1L;

        assertEquals(clientName, accountService.findById(clientId).getClientName());
    }

    @Test
    public void shouldAddAnAccount() {
        String clientName = "Dorian";
        long clientId = 6L;
        Account account = accountService.createAccount(clientName);

        assertEquals(account, accountService.findById(clientId));
    }

    @Test
    public void shouldNotFindAnyAccount() {
        long clientId = 6L;

        assertNull(accountService.findById(clientId));
    }

    @Test
    public void shouldDeleteAnAccount() {
        assertTrue(accountService.deleteIfExists(1L));
    }

    @Test
    public void shouldFindAllAccounts() {
        Iterable<Account> accounts = accountService.findAll();

        assertEquals(numberOfAccounts, accounts.spliterator().getExactSizeIfKnown());
    }
}
