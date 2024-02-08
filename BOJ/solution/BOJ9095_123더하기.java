/*
 * [BOJ]9095. 123더하기 - dp
 * 놓친 부분: 3을 더할 때 2+1 / 1+2가 같다고 생각함. 문제잘읽기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095_123더하기 {

	static int T;
	static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		int maxN = -1;
		int[] input = new int[T];
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			input[t] = n;
			maxN = Math.max(maxN, n);
//			sb.append(dp(n)).append("\n");
		}

		/**
		 * Bottom-up 방식
		 */
		int size = Math.max(maxN, 3);
		d = new int[size+1];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for (int i = 4; i <= maxN; i++) {
			d[i] = d[i-3] + d[i-2] + d[i-1];
		}

		for (int i = 0; i < T; i++) {
			sb.append(d[input[i]]).append("\n");
		}

		System.out.println(sb);
	}

	/**
	 * Top-down 방식
	 */
	private static int dp(int n) {
		if(n==1) return d[n]=1;
		if(n==2) return d[n]=2;
		if(n==3) return d[n]=4;

		if(d[n] != 0) return d[n];
		return d[n] = dp(n-1) + dp(n-2) + dp(n-3);
	}

}
