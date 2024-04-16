package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils {
    static Faker fakerRu = new Faker(new Locale("ru"));
    static Faker fakerEn = new Faker(new Locale("en"));
    private static final SimpleDateFormat DAY_FORMATTER = new SimpleDateFormat("dd", Locale.ENGLISH);
    private static final SimpleDateFormat MONTH_FORMATTER = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    private static final SimpleDateFormat YEAR_FORMATTER = new SimpleDateFormat("yyyy", Locale.ENGLISH);

    private static final List<String> subjects = Arrays.asList(
            "Hindi",
            "English",
            "Maths",
            "Physics",
            "Chemistry",
            "Biology",
            "Computer Science",
            "Commerce",
            "Accounting",
            "Economics",
            "Arts",
            "Social Studies",
            "History",
            "Civics"
    );
    private static  final List<String> states = Arrays.asList(
            "NCR",
            "Uttar Pradesh",
            "Haryana",
            "Rajasthan"
    );

    private static final Map<String, List<String>> STATES_CITIES = new HashMap<>(states.size()) {
        {
            put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
            put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
            put("Haryana", Arrays.asList("Karnal", "Panipat"));
            put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        }
    };

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
    public static String getRandomPhoneNumber(){
        return fakerEn.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomSubjects(String... used) {
        List<String> subjectsCopy = new ArrayList<>(subjects);
        subjectsCopy.removeAll(Arrays.asList(used));
        return fakerEn.options().nextElement(subjectsCopy);
    }

    public static String getRandomState(){
        return fakerEn.options().nextElement(states);
    }
    public static  String getRandomCity(String state){
        List<String> cities = STATES_CITIES.get(state);
        return fakerEn.options().nextElement(cities);
    }
    public static String getRandomHobby(){
        return fakerEn.options().option("Sports","Reading","Music");
    }
    public static Date getRandomDate(){
        return fakerEn.date().birthday();
    }
    public static String getRandomDayOfBirthday(Date date){
        return DAY_FORMATTER.format(date);
    }
    public static String getRandomMonthOfBirthday(Date date){
        return MONTH_FORMATTER.format(date);
    }
    public static String getRandomYearOfBirthday(Date date){
        return YEAR_FORMATTER.format(date);
    }
    public static String getPRandomPicture(){
        return fakerEn.options().option("picture1.jpg","picture2.jpg","picture3.jpg");
    }

}