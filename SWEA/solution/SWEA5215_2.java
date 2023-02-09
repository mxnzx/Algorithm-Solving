package solution;

/*
 * 5215. 햄버거 다이어트
 * 부분집합으로 가능한 조합 전부 구하고 basis 조건에서 골라내기
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

public class SWEA5215_2 {

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
			L = Integer.parseInt(st.nextToken()); // totalCal

			Ingred[] ingreds = new Ingred[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingreds[i] = new Ingred(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			//
			Ans = Integer.MIN_VALUE;
			bestBurger(ingreds, new boolean[N], 0, 0);

			System.out.printf("#%d %d\n", tc, Ans);

		}
	}

	/*
	 * ingreds : 입력받은 재료 정보배열 sel : 민기가 고른 재료 구분 배열. idx: 재료 정보 배열 인덱스 k : 고른 재료 배열
	 * 인덱스
	 */
	private static void bestBurger(Ingred[] ingreds, boolean[] sel, int idx, int k) {

		// ==== basis part ====
		// idx가 다 돌았을 경우에 조건문에 들어와
		if (idx == ingreds.length) {

			// 선택했는지에 대한 구분 배열을 가지고, 전체를 돈다.
			for (int i = 0; i < sel.length; i++) {

				// sel이 선택(true)이 된 것만 일단 현재의 score와 cal를 더한다.
				// 칼로리의 합 <= L 일때까지만
				if (sel[i] && sumCal + ingreds[i].cal<= L) {
					//
					sumCal += ingreds[i].cal;
					sumScore += ingreds[i].score;
					// System.out.print(sumCal + " " + sumScore + " ");
					// System.out.print(ingreds[i]+" ");
				}
			}

			 //sumScore를 현재 최대값(Ans)과 비교해서 Ans에 넣을지말지 조건을 건다.

			Ans = Math.max(Ans, sumScore);
			
			// 다음 ingreds 로 넘어가기 위해 sumCal, sumScore를 초기화 해준다.
			sumCal = 0;
			sumScore = 0;

			return;
		}

		// ==== inductive part ====
		// 일단 모든 조합을 다 넣어본다. 총 경우의 수는 nC0 + nC1 + nC2 + ... +nCn
		// 선택하는 경우
		sel[idx] = true;
		bestBurger(ingreds, sel, idx + 1, k + 1);

		// 선택하지 않는 경우
		sel[idx] = false;
		bestBurger(ingreds, sel, idx + 1, k);

	}

}
