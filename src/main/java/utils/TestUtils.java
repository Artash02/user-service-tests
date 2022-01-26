package utils;

import java.util.Random;

public class TestUtils {

    public static final Random random = new Random();
//    public static final Faker FAKER = new Faker();

    public static int getRandomInt() {
        return random.nextInt();
    }
}
