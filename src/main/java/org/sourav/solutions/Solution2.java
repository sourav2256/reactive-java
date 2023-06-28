package org.sourav.exercise;

import org.sourav.ReactiveSources;

import java.io.IOException;

public class Solution2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux()
                .subscribe(System.out::println);

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}