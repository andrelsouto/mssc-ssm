package br.com.andre.msscssm.actions;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import br.com.andre.msscssm.services.PaymentServiceImpl;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PreAuthActionImpl implements PreAuthAction {

    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("PreAuth was called");
        int approved = new Random().nextInt(10);
        System.out.println("\n\n\n\n\n\n\n\nApproved: " + approved + "\n\n\n\n\n\n\n\n");
        boolean showApproved = approved < 8;
        System.out.println(showApproved ? "Approved" : "Declined! No Credit!!!!");
        context.getStateMachine().sendEvent(
                MessageBuilder.withPayload(showApproved ? PaymentEvent.PRE_AUTH_APPROVED : PaymentEvent.PRE_AUTH_DECLINED)
                        .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER,
                                context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER))
                        .build());
    }
}
