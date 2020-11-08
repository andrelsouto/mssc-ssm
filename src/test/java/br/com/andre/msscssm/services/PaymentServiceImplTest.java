package br.com.andre.msscssm.services;

import br.com.andre.msscssm.domain.Payment;
import br.com.andre.msscssm.domain.PaymentState;
import br.com.andre.msscssm.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);

        assertEquals(PaymentState.NEW, savedPayment.getState());
        paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getOne(savedPayment.getId());

        assertEquals(PaymentState.PRE_AUTH, preAuthedPayment.getState());
    }

    @Transactional
    @RepeatedTest(10)
    void authorizePayment() {
        Payment savedPayment = paymentService.newPayment(payment);

        if (savedPayment.getState().equals(PaymentState.NEW)) {
            paymentService.preAuth(savedPayment.getId());
            System.out.println(paymentRepository.getOne(savedPayment.getId()));

            paymentService.authorizePayment(savedPayment.getId());
            System.out.println(paymentRepository.getOne(savedPayment.getId()));
        }
    }


}