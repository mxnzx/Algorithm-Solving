/*
 * N개중에 2개를 골라 값을 계산 그들(nC2개)끼리 짝지어 차를 구해서, 가장 작은 차를 정답으로 출력한다
 * 아니고.
 * N개 중에 N/2개를 골라 값을 계산
 * 하고 둘씩 짝지어서 둘 중 작은 차 정답
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10972_다음순열 {

	static int T, N, Ans;
	static int[][] map;
	static int[] s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			s = new int[N]; // 내가 고른 식재료 배열
			Ans = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				s[i] = i + 1;
			}
			int num = N / 2; // 재료 조합 개수

			//
			comb(new int[num], 0, 0);

			System.out.println(Arrays.toString(s));

			// 시너지 배열을 가운데 기준으로 2로 나누고 맨 바깥부터 짝짓는다. 그럼 nC2/2 개 중에서 최소값을 고르면 됨.
			for (int i = 0; i < s.length / 2; i++) {
				int sub = Math.abs(s[i] - s[s.length - 1 - i]);
				System.out.println(sub);
				Ans = Math.min(Ans, sub);
			}

			sb.append("#" + tc + " " + Ans + "\n");
		}
		System.out.println(sb);
		br.close();

	}

	private static void comb(int[] sel, int idx, int k) {

		if (k == sel.length) {
			// 각각 뽑은 수로 시너지의 합을 구한다. e.g. [1,2,3] -> map[1][2] + map[2][1] + map[1][3] +
			// map[3][1] + map[2][3] + map[3][2]
			// 여기서 뽑은 수로 순열 ?
			perm(sel, new int[2], 0, 0);
			
			return;
		}
		for (int i = idx; i < s.length; i++) {
			sel[k] = s[i];
			comb(sel, i + 1, k + 1);
		}

	}

	// 고른 두개를 가지고 순열을 만든다
	private static void perm(int[] og, int[] sel, int idx, int flag) {
		
		if(idx == sel.length) {
			int a = map[sel[0]][sel[1]] + map[sel[1]][sel[0]];
			//System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = 0; i < og.length; i++) {
			if((flag & (1<<i)) != 0) continue;
			sel[idx] = og[i];
			perm(og, sel, idx+1, flag|(1<<i));
			
		}
	}

}
