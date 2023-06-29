package org.sourav.solutions;

import org.reactivestreams.Subscription;
import org.sourav.ReactiveSources;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Solution5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono()
                .subscribe(
                        number -> System.out.println(number),
                        err -> System.out.println(err),
                        () -> System.out.println("Completed")
                );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

    static class MySubscriber<T> extends BaseSubscriber<T> {
        public void hookOnSubscriber() {
            System.out.println("Subscribe happened");
            //request(2);
        }

        public void hookOnNext(T value) {
            System.out.println(value.toString() + " received");
            //request(2);
        }
    }
}