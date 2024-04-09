package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    static Faker fakerRu = new Faker(new Locale("ru"));
    static Faker fakerEn = new Faker(new Locale("en"));

    public static String getRandomFirstName(){
        return fakerRu.name().firstName();
    }
    public static String getRandomLastName(){
        return fakerRu.name().lastName();
    }
    public static String getRandomEmail(){
        return fakerEn.internet().emailAddress();
    }
    public static String getRandomAddress(){
        return fakerRu.address().streetAddress();
    }

    public static String getGender(){
        return fakerEn.options().option("Male","Female","Other");
    }
}