import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        int lotto = ran.nextInt(3);
        System.out.println(lotto);
    }
}