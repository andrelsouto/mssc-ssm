package br.com.andre.msscssm.actions;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import br.com.andre.msscssm.services.PaymentServiceImpl;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AuthActionImpl implements AuthAction {
    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("Auth was called");
        int authorized = new Random().nextInt(10);
        System.out.println("\n\n\n\n\n\n\n\nAuthorized: " + authorized + "\n\n\n\n\n\n\n\n");
        boolean showAuthorized = authorized < 8;
        System.out.println(showAuthorized ? "Approved" : "Declined! No Credit!!!!");
        context.getStateMachine().sendEvent(
                MessageBuilder.withPayload(showAuthorized ? PaymentEvent.AUTH_APPROVED : PaymentEvent.AUTH_DECLINED)
                        .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER,
                                context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER))
                        .build());
    }
}
