package Lab1;
import java.util.Scanner;
public class AddTwoMatrices {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numbers of rows and columns: ");
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int[][] matrix1= new int[rows][cols];
		int[][] matrix2= new int[rows][cols];
		int[][] result= new int[rows][cols];
		System.out.print("Enter matrix1: ");
		for (int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				System.out.print("matrix1[" + i + "][" +j+"] = " );
				matrix1[i][j]=sc.nextInt();
			}
		}
		System.out.print("Enter matrix2: ");
		for (int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				System.out.print("matrix2[" + i + "][" +j+"] = " );
				matrix2[i][j]=sc.nextInt();
			}
		}
		for (int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				result[i][j]= matrix2[i][j] + matrix1[i][j];
			}
		}
		System.out.print("Result:\n ");
		for (int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				System.out.printf("%2d ", result[i][j] );
			}
			System.out.print("\n ");
		}
	
	}
}
