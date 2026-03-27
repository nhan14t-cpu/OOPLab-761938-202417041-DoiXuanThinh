package week1;
import java.util.Arrays;
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numbers of Array: ");
        int n = sc.nextInt();
        int[] myArray = new int[n];
        System.out.print("Enter " + n + " numbers ");
        for (int i = 0; i < n; i++) {
            myArray[i] = sc.nextInt();
        }
        Arrays.sort(myArray);
        System.out.println("Sorted array: " + Arrays.toString(myArray));
        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / n;
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements : " + average);
    }
}
