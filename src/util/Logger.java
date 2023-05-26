package util;

public class Logger {

    public static void lnlog(String message) {
        System.out.println();
        log(message);
    }

    public static void log(String message) {
        System.out.println(message);
    }

}
