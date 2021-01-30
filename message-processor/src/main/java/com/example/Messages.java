package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.function.Consumer;

@Component
@Qualifier("rawHandler")
public class Messages extends Observable implements Consumer<String> {

    final
    MessageQueue queue;

    public Messages(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void accept(String s) {
        System.out.println("deserialize!");
        queueMessage(s);
    }

    public void queueMessage(String s) {
        queue.messages.add(s);
        setChanged();
        notifyObservers(s);
    }

    public String getMessage() {
        return queue.messages.remove();
    }
}
