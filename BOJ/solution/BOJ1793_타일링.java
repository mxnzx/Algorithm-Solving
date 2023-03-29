package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1793_타일링 {

		static int n;
		static BigInteger[] d;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String input="";
			while((input = br.readLine()) != null && !input.isEmpty()) {
				n = Integer.parseInt(input);
				d = new BigInteger[n+1];
				for (int i = 0; i <= n; i++) {
					d[i] = BigInteger.valueOf(0);
				}
				sb.append(dp(n)).append("\n");
			}
			System.out.println(sb);
	}
		private static BigInteger dp(int n) {
			if(n==0) return BigInteger.valueOf(1);
			if(n==1) return BigInteger.valueOf(1);
			if(n==2) return BigInteger.valueOf(3);
			if(d[n].compareTo(BigInteger.valueOf(0)) != 0) return d[n];
			return d[n] = dp(n-1).add(dp(n-2).multiply(new BigInteger("2")));
		}

}
