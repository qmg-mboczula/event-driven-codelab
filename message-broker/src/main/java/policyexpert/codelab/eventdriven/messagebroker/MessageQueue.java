package policyexpert.codelab.eventdriven.messagebroker;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {

    private final List<Message> messageQueue = new ArrayList<>();
    private final List<MessageConsumer> consumers = new ArrayList<>();

    public synchronized void publishMessage(Message message) {
        messageQueue.add(message);
    }

    public synchronized void subscribe(MessageConsumer consumer) {
        consumers.add(consumer);
    }

    public synchronized void dispatch() {
        if(!messageQueue.isEmpty()) {
            var message = messageQueue.removeFirst();
            consumers.forEach(consumer -> consumer.consumeMessage(message));
        }
    }

}
