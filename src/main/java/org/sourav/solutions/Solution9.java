package org.sourav.solutions;

import org.sourav.ReactiveSources;

import java.io.IOException;

public class Solution9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        ReactiveSources.intNumbersFlux()
                .count()
                .subscribe(System.out::println);

        // Collect all items of intNumbersFlux into a single list and print it
        ReactiveSources.intNumbersFlux()
                .log()
                .collectList()
                .log()
                .subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}