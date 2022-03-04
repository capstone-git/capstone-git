package ui.objects;

import net.bytebuddy.utility.RandomString;

import java.util.Locale;

public class Utils {

    public static String getRandomString(int length){
        return new RandomString(length).nextString().toLowerCase(Locale.ROOT);
    }

    public static String getRandomEmail(){
        return getRandomString(5)+"@example.com";
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
