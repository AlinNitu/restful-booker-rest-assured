package utils;

import com.github.javafaker.Faker;

public class RandomiserHelper {

    public static Faker faker = new Faker();

    public static String generateRandomFirstName() {

        return faker.name().firstName();
    }

    public static String generateRandomLastName() {

        return faker.name().lastName();
    }

    public static double generateRandomPrice() {

        return faker.number().randomDouble(2, 1, 999);
    }

    public static boolean generateRandomDepositPaid() {

        return faker.bool().bool();
    }

}
