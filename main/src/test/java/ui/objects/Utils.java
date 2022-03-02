package ui.objects;

import net.bytebuddy.utility.RandomString;

import java.util.Locale;

public class Utils {

    public static String getRandomSting(int length){
        return new RandomString(length).nextString().toLowerCase(Locale.ROOT);
    }
}
