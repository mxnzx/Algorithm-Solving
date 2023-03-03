package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고스탁 {
	
	static int T, Ms, Ma, N, L;
	static int[][] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());    //예치금
			Ma = Integer.parseInt(st.nextToken());    //월별불입금액
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//종목 1번부터
			L = Integer.parseInt(st.nextToken());	//개월 0개월부터 -> 주식시세
			price = new int[N+1][L+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L+1; j++) {
					price[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
			//다음달과의 주가 차이를 나타내고 가장 많이나는 종목과 
			//모든 종목이 다음달 주가가 더 작거나 같으면 그대로 저축
			//하나라도 다음 달 주가가 더 높으면 매수(다)
			//그 다음날 무조건 매도한다
			//가장 차이가 많이 나는 종목을 전부 매수
			for (int i = 1; i <= N; i++) {
				
				for (int j = 0; j < L+1; j++) {
					System.out.print(price[i][j] + " ");
				}	
				System.out.println();
			}
			//L+1번
			for (int m = 0; m < L+1; m++) {
				//앞 달과 내것을 비교
			//	종목별로
				for (int i = 1; i <= N; i++) {
					if(price[i][m] >=price[i][m+1]) continue;
					//다음달이 더 커지는 구간의 i(종목),m(개월)값을 저장
					
				}
			}
			
			
			
		}

	}

}
