package com.ing.tech.devschool.testing.service;

import com.ing.tech.devschool.testing.api.model.Account;
import com.ing.tech.devschool.testing.api.repository.AccountRepository;
import com.ing.tech.devschool.testing.api.repository.TransactionRepository;
import com.ing.tech.devschool.testing.api.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService transactionService;


    @Test
    public void shouldTransferAmountAndUpdateBalances() {
        Account sender = Account.builder().accountNumber(1L).totalBalance(1000.0).build();
        Account receiver = Account.builder().accountNumber(2L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        assertTrue(transactionService.transfer(sender.getAccountNumber(),
            receiver.getAccountNumber(),
            500.0));
        verify(transactionRepository, times(1)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(500.0, sender.getTotalBalance(), 0.01);
        assertEquals(1500.0, receiver.getTotalBalance(), 0.01);
    }

    @Test
    public void shouldNotTransferIfNegativeAmount() {
        //TODO

    }

    @Test
    public void shouldNotTransferIfInsufficientBalance() {
        //TODO

    }

    @Test
    public void shouldNotTransferIfSenderOrReceiverNotPresent() {
        //TODO

    }

    @Test
    public void shouldDepositAmount() {
        //TODO

    }

    @Test
    public void shouldWithdrawAmount() {
        //TODO

    }

    @Test
    public void shouldNotWithdrawIfInsufficientBalance() {
        //TODO

    }

}
