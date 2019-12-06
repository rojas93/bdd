package dataGenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class DataGenerator {

    private static final Faker fakerRU = new Faker(new Locale("ru"));
    private static final Faker fakerEN = new Faker(new Locale("en"));
    private static final FakeValuesService fakeValuesServiceRU = new FakeValuesService(new Locale("RU"), new RandomService());
    private static final FakeValuesService fakeValuesServiceEU = new FakeValuesService(new Locale("en"), new RandomService());


    private DataGenerator() {}

    public static Stream<HashMap<String, String>> getCredLogin() {

        HashMap<String, String> value1 = new HashMap<String, String>(){{
            put("login", "vasya");
            put("password", "qwerty123");
            put("code", "12345");
        }};

        return Stream.of(value1);
    }

}
