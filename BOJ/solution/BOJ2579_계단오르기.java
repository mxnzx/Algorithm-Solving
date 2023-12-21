package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_계단오르기 {

	static int n;
	static int[] score;
	static Integer[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		score = new int[n+1];
		for (int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		d = new Integer[n+1];

		d[0] = 0;
		d[1] = score[1];
		if(n>=2) d[2] = score[1] + score[2];
		System.out.println(dp(n));
	}

	private static int dp(int n) {

		if(d[n] != null) return d[n];
		return d[n] = Math.max(dp(n-2), dp(n-3)+score[n-1]) + score[n];
	}
}
