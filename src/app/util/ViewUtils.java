package app.util;

public class ViewUtils {
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clear() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
 }
