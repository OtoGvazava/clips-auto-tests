package util;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomData extends RandomStringUtils {
    public static String randomIncorrectEmail() {
        return randomAlphabetic(10) + "@" + randomAlphabetic(4);
    }

    public static String randomIncorrectPassword() {
        return randomAlphanumeric(10, 10);
    }
}
