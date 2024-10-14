import policyexpert.codelab.eventdriven.messagebroker.MessageQueue;
import policyexpert.codelab.eventdriven.notification.PaymentMessageConsumer;
import policyexpert.codelab.eventdriven.payment.PaymentService;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Main {

    private static final Random random = new Random();
    private static final MessageQueue broker = new MessageQueue();
    private static final PaymentService paymentService = new PaymentService(broker);
    private static final PaymentMessageConsumer paymentMessageConsumer = new PaymentMessageConsumer();


    public static void main(String[] args) throws InterruptedException {
        // TODO register payment message consumer as a subscriber of the message broker
        Thread paymentSuccessfulPublisherThread = Thread.startVirtualThread(() -> {
            while(true) {
                try {
                    sleep(1000);
                    paymentService.publishPaymentSuccessful(
                            generateRandomEmail(),
                            generateRandomPhoneNumber(),
                            generateRandomBody()
                    );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread messageDispatcherThread = Thread.startVirtualThread(() -> {
            while(true) {
                try {
                    sleep(1000);
                    broker.dispatch();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        paymentSuccessfulPublisherThread.join();
        messageDispatcherThread.join();

    }

    private static String generateRandomEmail() {
        return UUID.randomUUID() + "@email.com";
    }

    private static String generateRandomPhoneNumber() {
        return String.join("", IntStream.range(0, 9)
                .mapToObj(i ->
                        Integer.toString(random.nextInt(0, 9))).toList()
        );
    }

    private static String generateRandomBody() {
        return Integer.toString(random.nextInt(100));
    }
}
