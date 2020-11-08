package br.com.andre.msscssm.actions;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Component;

@Component
public class AuthApprovedActionImpl implements AuthApprovedAction {
    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> stateContext) {
        System.out.println("Sending Notification of Auth Approved");
    }
}
