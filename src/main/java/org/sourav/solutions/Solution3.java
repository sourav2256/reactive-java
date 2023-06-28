package org.sourav.exercise;

import org.sourav.ReactiveSources;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        ReactiveSources.intNumbersFlux()
                .collectList()
                .subscribe(System.out::println);

        List<Integer> list = ReactiveSources.intNumbersFlux()
                .toStream()
                .toList();

        System.out.println("List " + list);
        System.out.println("List size: " + list.size());

        Mono<List<Integer>> monoList = ReactiveSources.intNumbersFlux()
                .collect(Collectors.toList());

        monoList.subscribe(l -> {
            System.out.println("List " + l);
            System.out.println("List size: " + l.size());
        });

        System.out.println("Press a key to end");
        System.in.read();
    }

}