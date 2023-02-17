package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1859_백만장자 {
	
	static int T, N, Ans;
	static int[] price;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			Ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			/*
			 *  
			 * 나보다 큰 값이 - 있으면 사고. 가장 큰 값에 판다  -없으면 continue
			 * 있을 때 매매가 차이 확인 후 값을 더한다
			 */
			
			int n = 0;
			
			for (int i = n+1; i < price.length; i++) {
				int max=0;
				
				if(price[n] < price[i]) {
					max=Math.max(max, price[i]);  //가장 큰 맥스값 찾어
					System.out.println(max);
					Ans += (max - price[n]);	  //맥스 값과 
				}
				
				
			}
			n++;

			sb.append("#" + tc + " " + Ans + "\n");
		}
		System.out.println(sb);
		br.close();
		
	}

}
