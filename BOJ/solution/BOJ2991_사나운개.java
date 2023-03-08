package solution;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2991_사나운개 {
	static int A, B, C, D, P, M, N;
	static int[] barkTime = new int[1000];
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		P = sc.nextInt();	//우체부
		M = sc.nextInt();	//우유배달원
		N = sc.nextInt();	//신문배달원
		int[] arr = {P,M,N};
		Arrays.sort(arr);

		//가장 늦게오는 사람이 도착할때까지
		for (int i = 1; i <= arr[2]; i+=A+B) {
			for (int j = i; j < i+A; j++) {
				barkTime[j]++;
			}
		}
		for (int i = 1; i <= arr[2]; i+=C+D) {
			for (int j = i; j < i+C; j++) {
				barkTime[j]++;
			}
		}
		System.out.println(barkTime[P]);
		System.out.println(barkTime[M]);
		System.out.println(barkTime[N]);

	}

}
