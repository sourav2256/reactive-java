package org.sourav;

import java.io.IOException;

public class Solution4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here

        ReactiveSources.intNumberMono()
                .log()
                .subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        // TODO: Write code here


        System.out.println("Press a key to end");
        System.in.read();
    }

}