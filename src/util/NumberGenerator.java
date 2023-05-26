package util;

public class NumberGenerator {

    public static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        String number;
        while(i < length) {
            number = String.valueOf(randomInt());
            if (builder.indexOf(number) == -1) {
                builder.append(number);
                i++;
            }
        }
        return builder.toString();
    }

    private static int randomInt() {
        return (int) (Math.random() * 9 + 1);
    }

}