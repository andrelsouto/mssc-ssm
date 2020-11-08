package br.com.andre.msscssm.actions;

import br.com.andre.msscssm.domain.PaymentEvent;
import br.com.andre.msscssm.domain.PaymentState;
import org.springframework.statemachine.action.Action;

public interface AuthApprovedAction extends Action<PaymentState, PaymentEvent> {
}
