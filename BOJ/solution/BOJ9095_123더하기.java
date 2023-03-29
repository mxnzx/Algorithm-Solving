/*
 * [BOJ]9095. 123더하기 - dp
 * 놓친 부분: 3을 더할 때 2+1 / 1+2가 같다고 생각함. 문제잘읽기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095_123더하기 {

	static int T, n;
	static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			d = new int[n+1];
			sb.append(dp(n)).append("\n");
		}
		System.out.println(sb);
	}
	private static int dp(int n) {
		if(n==1) return d[n]=1;
		if(n==2) return d[n]=2;
		if(n==3) return d[n]=4;
		
		if(d[n] != 0) return d[n];
		return d[n] = dp(n-1) + dp(n-2) + dp(n-3);
	}

}
