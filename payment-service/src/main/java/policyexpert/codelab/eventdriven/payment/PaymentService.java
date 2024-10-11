package policyexpert.codelab.eventdriven.payment;

import policyexpert.codelab.eventdriven.messagebroker.Message;
import policyexpert.codelab.eventdriven.messagebroker.MessageQueue;

import java.util.Collections;
import java.util.Map;

public class PaymentService {

    private final MessageQueue messageQueue;

    public PaymentService(
            MessageQueue messageQueue
    ) {
        this.messageQueue = messageQueue;
    }

    public void publishPaymentSuccessful(
            String email,
            String value
    ) {
        String body = email + ", " + value;
        System.out.println("Publishing message: " + body);
        messageQueue.publishMessage(
                new Message(Map.of("email", email), value)
        );
    }
}
