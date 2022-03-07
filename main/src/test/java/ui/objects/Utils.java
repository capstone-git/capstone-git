package ui.objects;

import net.bytebuddy.utility.RandomString;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

import static ui.pages.payment.Payment.invoicePath;

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

    public static boolean isFileExist(){
        File file = new File(invoicePath.getAbsolutePath() + File.separator + "invoice.txt");
        Pages.waitFile(file);
        if (file.isFile()) {
            try {
                Files.delete(Paths.get(file.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
