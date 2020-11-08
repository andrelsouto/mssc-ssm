package br.com.andre.msscssm.guard;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import br.com.andre.msscssm.services.PaymentServiceImpl;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

@Component
public class PaymentGuardImpl implements PaymentGuard {
    @Override
    public boolean evaluate(StateContext<PaymentState, PaymentEvent> context) {
        return context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER) != null;
    }
}
