package br.com.andre.msscssm.services;

import br.com.andre.msscssm.domain.Payment;
import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(long paymentId);
}
