package policyexpert.codelab.eventdriven.notification;

import policyexpert.codelab.eventdriven.messagebroker.Message;
import policyexpert.codelab.eventdriven.messagebroker.MessageConsumer;

public class PaymentMessageConsumer implements MessageConsumer {

    private final EmailService emailService = new EmailService();

    @Override
    public void consumeMessage(Message message) {
        // TODO 1 implement sending email
        // TODO 2 implement sending sms
    }
}
