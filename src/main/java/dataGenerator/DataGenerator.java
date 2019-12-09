package dataGenerator;

import data.User;

import java.util.stream.Stream;

public class DataGenerator {

    private DataGenerator() {}

    public static Stream<User> getCredLogin() {
        return Stream.of(new User("vasya", "qwerty123", "12345"));
    }

}
