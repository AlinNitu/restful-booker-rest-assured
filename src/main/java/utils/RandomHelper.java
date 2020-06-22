package utils;

import com.github.javafaker.Faker;

public class RandomHelper {

    public static Faker faker = new Faker();

    public static String generateRandomFirstName() {

        return faker.name().firstName();
    }

    public static String generateRandomLastName() {

        return faker.name().lastName();
    }

    public static int generateRandomPrice() {

        return faker.number().numberBetween(1, 999);
    }

    public static boolean generateRandomDepositPaid() {

        return faker.bool().bool();
    }

}
