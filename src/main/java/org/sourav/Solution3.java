package org.sourav;

import java.io.IOException;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here

        ReactiveSources.intNumbersFlux()
                .collectList()
                .log()
                .subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}