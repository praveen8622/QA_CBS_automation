package utilities;

import java.util.Random;

public class DataGenerator {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final Random RANDOM = new Random();

    /**
     * Generates a random numeric string of specified length.
     */
    public static String generateRandomNumber(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        }
        return result.toString();
    }

    /**
     * Generates a random alphanumeric string of specified length.
     */
    public static String generateRandomAlphanumeric(int length) {
        String combined = ALPHABET + NUMBERS;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(combined.charAt(RANDOM.nextInt(combined.length())));
        }
        return result.toString();
    }

    /**
     * Generates a random passport-like number (e.g., P + 8 digits).
     */
    public static String generateRandomPassport() {
        return "P" + generateRandomNumber(8);
    }

    /**
     * Generates a random license-like number with dashes.
     */
    public static String generateRandomLicense() {
        return generateRandomNumber(3) + "-" + generateRandomNumber(3) + "-" + generateRandomNumber(5);
    }
}
