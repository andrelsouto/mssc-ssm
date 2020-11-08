package br.com.andre.msscssm.guard;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import org.springframework.statemachine.guard.Guard;

public interface PaymentGuard extends Guard<PaymentState, PaymentEvent> {

}
