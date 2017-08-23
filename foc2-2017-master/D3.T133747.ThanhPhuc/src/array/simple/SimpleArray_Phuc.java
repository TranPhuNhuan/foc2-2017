package array.simple;
import java.awt.*;
import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class SimpleArray_Phuc {
	public static void main (String[] args) throws Exception{
		int n,i;
		int a[]=new int[100];
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap so phan tu n: ");
		n = input.nextInt();
		for( i = 0; i < n; i++){
			System.out.println("Nhap vao gia tri a["+i+"]=");
			a[i]=input.nextInt();
		}
		System.out.println("So chia het cho 7 hoac chia het cho 2 la: ");
		for(i=0;i<n;i++){
			if(a[i]%7==0 || a[i]%2==0){
				System.out.print(a[i] + ";");
			}
		}
		
		//for( i = 0; i < n; i++){
			//System.out.println("Nhap vao gia tri a["+i+"]=");
			//a[i]=input.nextInt();
		//}
		System.out.println("So chia het cho 5 va khong chia het cho 3 la: ");
		
		for(i=0;i<n;i++){
			if(a[i]%5==0 & a[i]%3==1){
				System.out.print(a[i] + ";");
			}
		}

	}
}
