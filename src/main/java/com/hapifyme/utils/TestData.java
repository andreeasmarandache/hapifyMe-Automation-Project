package com.hapifyme.utils;

import java.util.Random;

public class TestData {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return sb.toString();
    }

    public static String randomNames(){
        return randomString(6);
    }

    public static String randomEmail() {
        return randomString(8) + "@test.com";
    }

    public static String randomPassword() {
        return randomString(8) + "4A!";
    }
}
