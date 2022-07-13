package com;

import java.util.Optional;

public class OptionalTest {
    static Optional<String> returnString() {
        return Optional.ofNullable(null);
    }


    public static void main(String[] args){
        System.out.println(returnString());
    }
}
