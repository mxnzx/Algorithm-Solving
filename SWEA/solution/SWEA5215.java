package solution;

/*
 * 5215. 햄버거 다이어트
 * 조합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Ingred {
	int score;
	int cal;
	
	public Ingred(int score, int cal) {
		this.score = score;
		this.cal = cal;
	}

	@Override
	public String toString() {
		return "Ingred [score=" + score + ", cal=" + cal + "]";
	}
	
}

public class SWEA5215 {
	
	static int T, N, L, Ans;
	static int sumCal, sumScore;

	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("./input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sumCal = 0;
			sumScore = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	
			L = Integer.parseInt(st.nextToken());	//totalCal
			
			Ingred[] ingreds = new Ingred[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingreds[i] = new Ingred(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			
			//
			Ans = Integer.MIN_VALUE;
			bestBurger(ingreds, new Ingred[N], 0, 0);

			
			System.out.printf("#%d %d\n",tc, Ans);
			
		}
	}
	/*
	 * ingreds : 입력받은 재료 정보배열
	 * sel : 민기가 고른 재료 배열
	 * idx: 재료 정보 배열 인덱스
	 * k : 고른 재료 배열 인덱스
	 */
	private static void bestBurger(Ingred[] ingreds, Ingred[] sel, int idx, int k) {
		
		// ==== basis part ====

		//==== inductive part ====
		//sumCal가 1000이 넘지 않는지 체크한다. -> 안하면 값을  sel에 넣고 계산. 넘으면 나와서 현재까지의 값을 비교해서 Ans값을 갱신.
		for (int i = idx; i < ingreds.length; i++) {
			
			if(sumCal+ingreds[i].cal <= L) {
				//넘지 않으면 값을  sel에 넣고 계산.
				sel[k] = ingreds[i];
				sumScore += sel[k].score;
				sumCal += sel[k].cal;
				bestBurger(ingreds, sel, i+1, k+1);
				//돌아올 때 현재 값을 계산에서 빼준다. 그리고 다음.
				sumScore -= sel[k].score;
				sumCal -= sel[k].cal;
			}
			
			
		}
		//넘으면 나와서 현재까지의 값을 비교해서 Ans값을 갱신
		System.out.println("before: "+Ans);
		Ans = Math.max(Ans, sumScore);
		System.out.println("after: "+Ans);
		
	}

}
