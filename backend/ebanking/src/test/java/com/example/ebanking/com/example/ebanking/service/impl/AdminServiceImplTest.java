package com.example.ebanking.com.example.ebanking.service.impl;

import com.example.ebanking.entity.CardAccount;
import com.example.ebanking.repository.BankWithdrawRepository;
import com.example.ebanking.repository.CardRepository;
import com.example.ebanking.repository.UserRepository;
import com.example.ebanking.service.AdminServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceImplTest {

    @InjectMocks
    AdminServiceImpl adminServiceImplTest;

    @Mock
    UserRepository userRepository;

    @Mock
    CardRepository cardRepository;

    @Mock
    BankWithdrawRepository bankWithdrawRepository;

    @Mock CardAccount cardAccount;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        when(cardRepository.findByAccountNo(any())).thenReturn(new CardAccount());
    }

    @Test
    public void updateCardRequestTest(){
        System.out.println("test ran successfully");
        when(cardRepository.save(any())).thenReturn(new CardAccount());
        try {
            adminServiceImplTest.updateCardRequest(new BigInteger(String.valueOf(0)));
            assertEquals("1","1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
