package solution;

import java.util.Scanner;

public class BOJ14852_타일채우기3 {

	static int N;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new int[N+1];
		System.out.println(dp(N));
		
	}

	private static int dp(int n) {
		if(n==0) return 1;
		if(n==1) return 2;
		if(n==2) return 7;
		if(d[n] != 0) return d[n];
		int res = 2*dp(n-1) + 3*dp(n-2);
		for (int i = 3; i <= n; i++) {
			res += 2*dp(n-i);
		}
		return d[n] = res % 1000000007;

	}


}
