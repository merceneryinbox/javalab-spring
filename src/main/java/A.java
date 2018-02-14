import java.util.Locale;

public class A {
    public static void main(String[] args) {
        Object o      = new Object();
        String format = String.format(Locale.ENGLISH, "%s", o.toString());
        System.out.println(format);
    }
}
