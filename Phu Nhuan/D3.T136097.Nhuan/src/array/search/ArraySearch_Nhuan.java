/**
 * 
 */
package array.search;
import java.util.Random;
import java.util.Scanner;
/**
 * @author US
 *
 */
public class ArraySearch_Nhuan {

	/**
	 * @param args
	 */
	
	
	
	public static int[] Num = new int[100];
	public static Random rn = new Random();

	public static void Solve() {
		int count = 0;
		int countso = 0;
		for (int i = 0; i < Num.length; i++) {
			int range = 50 - 10 + 1;
			Num[i] = 10 + rn.nextInt(range);
		}

		int dong = 1;
		for (int so : Num) {
			if (count % 10 == 0) {
				System.out.println();
				System.out.print("Dong " + dong + ": ");
				dong++;

				System.out.print(so + " ");

			} else {
				System.out.print(so + " ");

			}
			count++;
		}

		System.out.println();
		Scanner scanIn = new Scanner(System.in);
		int n = 0;
		System.out.println("Nhap vao so n :");
		boolean nhap = true;
		while (nhap == true) {
			n = scanIn.nextInt();
			if (n < 10 || n > 50) {
				System.out.println("Ban phai nhap so n trong khoan tu 10 den 50");

			} else {
				nhap = false;
			}
		}

		int[][] a = convert_1D_To_2D(Num, 10, 10);
		int countTimesn = 0;

		for (int i = 0; i < Num.length; i++) {
			if (n == Num[i]) {

				countTimesn++;

			}
		}
		System.out.println("so nguyen duong n: " + n + " xuat hien: " + countTimesn + " lan ");

		System.out.println("vitri ");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (n == a[i][j]) {
					System.out.println(
							"so nguyen duong n: " + n + " xuat hien tai vi tri dong : " + (i + 1) + " cot :" + (j + 1));
				}
			}
		}

	}

	public static int[][] convert_1D_To_2D(int[] array, int rows, int cols) {
		if (array.length != (rows * cols)) {
			throw new IllegalArgumentException("Chieu dai mang khong hop le");
		}

		int[][] arr2d = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			System.arraycopy(array, (i * cols), arr2d[i], 0, cols);
		}

		return arr2d;
	}

	public static void main(String[] args) {

		Solve();
	}

}
