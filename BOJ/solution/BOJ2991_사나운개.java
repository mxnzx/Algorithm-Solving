package solution;

import java.util.Scanner;

public class BOJ2991_사나운개 {
	static int A, B, C, D, P, M, N;
	static int[] barkTime = new int[999];
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		P = sc.nextInt();	//우체부
		M = sc.nextInt();	//우유배달원
		N = sc.nextInt();	//신문배달원
		
		int n=0, m=0;
		while(n<100) {
			for (int i = n, nEnd=n+A; i < nEnd; i++) {
				barkTime[i]++;
			}
			for (int i = m, mEnd=n+C; i < mEnd; i++) {
				barkTime[i]++;
			}
			n+=A+B;
			m=C+D;
		}
		
		System.out.println(barkTime[P]);
		System.out.println(barkTime[M]);
		System.out.println(barkTime[N]);

	}

}
