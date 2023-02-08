/*
 * BOJ2798. 블랙잭
 * 중복X, 순서X -> 조합
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
	static int N, M, Ans;
	static int[] card;
	static int min, sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		card = new int[N];
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		//------------------------------------------------
		
		System.out.println(comb(new int[3],0,0));

	}
	/*
	 * idx = 카드 배열 인덱스
	 * k = 고른 배열 인덱스
	 */
	private static int comb(int[] sel, int idx, int k) {
		
		if(k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			//세개를 더해서 M과의 차이를 min값과 비교. sum을 리턴한다
			sum = 0;
			for (int i : sel) {
				sum += i;
			}
			if(sum<=M && Math.abs(M-sum) <= min) {				
				min = Math.abs(M-sum);
				Ans = sum;
				
			}
			return 0;
			
		}
		
		for(int i=idx; i<card.length; i++) {
			sel[k] = card[i];
			comb(sel, i+1, k+1);
		}
		return Ans;
		
	}

}
