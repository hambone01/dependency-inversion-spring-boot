package com.example;



import org.springframework.stereotype.Service;

@Service
public class MessageService {

    final
    Messages af;

    public MessageService(Messages af) {
        this.af = af;
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void consumeMessages()
    {
        af.addObserver(
                (o, arg) -> {
                    if (o == af) {
                        print(af.getMessage());
                    }
                });
    }
}
