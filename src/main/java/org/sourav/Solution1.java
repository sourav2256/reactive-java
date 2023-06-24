package org.sourav;

import java.util.Set;
import java.util.stream.Collectors;

public class Solution1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);

        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(User::getLastName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream

        StreamSources.intNumbersStream()
                .flatMap((id -> StreamSources.userStream().filter(user -> id == user.getId())))
                .map(User::getFirstName)
                .forEach(System.out::println);

        StreamSources.userStream()
                .filter((user -> StreamSources.intNumbersStream().anyMatch(id -> id == user.getId())))
                .map(User::getFirstName)
                .forEach(System.out::println);

        Set<Integer> set = StreamSources.intNumbersStream().collect(Collectors.toSet());

        StreamSources.userStream()
                .filter((user -> set.contains(user.getId())))
                .map(User::getFirstName)
                .forEach(System.out::println);

    }

}
