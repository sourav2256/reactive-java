package org.sourav.exercises;

import org.sourav.ReactiveSources;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class Solution8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(num -> System.out.println(num),
                        err -> System.out.println(err));

        ReactiveSources.intNumbersFluxWithException()
                .doOnError(err -> System.out.println(err.getMessage()))
                .subscribe(num -> System.out.println(num));

        // Print values from intNumbersFluxWithException and continue on errors

        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err, item) -> System.out.println(err.getMessage()))
                .subscribe(num -> System.out.println(num));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2

        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}