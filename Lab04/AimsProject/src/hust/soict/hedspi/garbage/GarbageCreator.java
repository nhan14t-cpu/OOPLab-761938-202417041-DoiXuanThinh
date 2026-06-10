package hust.soict.hedspi.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.txt"; //tạo 1 file txt để test
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("GarbageCreator time: " + (endTime - startTime) + "ms");
    }
}