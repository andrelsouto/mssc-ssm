package br.com.andre.msscssm.actions;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Component;

@Component
public class PreAuthDeclinedActionImpl implements PreAuthDeclinedAction {
    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> stateContext) {
        System.out.println("Sending Notification of PreAuth Declined");
    }
}
