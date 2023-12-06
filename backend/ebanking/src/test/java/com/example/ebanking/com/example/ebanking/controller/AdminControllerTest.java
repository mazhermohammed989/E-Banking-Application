package com.example.ebanking.com.example.ebanking.controller;

import com.example.ebanking.EbankingApplication;
import com.example.ebanking.controller.AdminController;
import com.example.ebanking.entity.BankAccount;
import com.example.ebanking.repository.BankAccountRepository;
import com.example.ebanking.service.AdminService;
import com.example.ebanking.service.AdminServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {EbankingApplication.class, AdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {

     @Autowired MockMvc mockMvc;

    @Autowired
    AdminService adminService;

    @MockBean
    BankAccountRepository bankAccountRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        when(bankAccountRepository.findAll()).thenReturn(Arrays.asList(new BankAccount()));
    }

    @Test
    public void restTest() throws Exception {
        mockMvc.perform(get("/admin/bankUser"))
                .andExpect(status().isOk());
    }
}
