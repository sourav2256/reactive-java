package org.sourav.solutions;

import org.sourav.ReactiveSources;

import java.io.IOException;

public class Solution4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono()
                .subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Integer monoInt = ReactiveSources.intNumberMono().block();


        System.out.println("Press a key to end");
        System.in.read();
    }

}