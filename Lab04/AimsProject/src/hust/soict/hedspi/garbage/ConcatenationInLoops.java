package hust.soict.hedspi.garbage;
import java.util.Random;
public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Cách 1: Dùng toán tử +
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++)
            s += r.nextInt(2);
        System.out.println("Dùng '+' : " + (System.currentTimeMillis() - start) + "ms");
        // Cách 2: Dùng StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++)
            sb.append(r.nextInt(2));
        s = sb.toString();
        System.out.println("Dùng StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
        // Cách 3: Dùng StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 65536; i++)
            sbf.append(r.nextInt(2));
        s = sbf.toString();
        System.out.println("Dùng StringBuffer: " + (System.currentTimeMillis() - start) + "ms");
    }
}