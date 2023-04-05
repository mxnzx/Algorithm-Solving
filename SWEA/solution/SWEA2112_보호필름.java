//시간 초과뜸
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {
	static StringBuilder sb = new StringBuilder();
	static int T, D, W, K, ans;
	static int[][] film;
	static int[] pass;
	static boolean isDone = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 연속해야하는 막의 개수
			ans = 0;
			isDone = false;
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				} // 0: A, 1:B
			}
			// 일단 검사
			if(checkCell(film)) {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			} else {
				int cnt = changeCell();
				sb.append("#").append(tc).append(" ").append(cnt).append("\n");
				
			}

		}
		System.out.println(sb);
	}

	private static int changeCell() {

		// nC1부터 시작
		for (int i = 1; i <= D; i++) {
			// 뽑아온 애들을 A로 바꾸는 경우와 B로 바꾸는 경우의 수가 있다 -> 복사해서 쓴다
			comb(0, 0, new int[i]);
			if (isDone)
				return i;
		}
		return 0;

	}

	// idx: 뽑으려는 인덱스, k:뽑은 개수
	private static void comb(int idx, int k, int[] sel) {

		if (k == sel.length) {
			// A로 바꿀지 B로 바꿀지 다해본다
			choiceAB(sel, new int[sel.length], 0, 0);
			return;
		}
		if (isDone) return;

		for (int i = idx; i < D; i++) {
			sel[k] = i;
			comb(i + 1, k + 1, sel);
		}
		return;

	}

	private static void choiceAB(int[] arr, int[] sel, int idx, int k) {
//		System.out.println("내가 바꿀 인덱스: " + Arrays.toString(arr));

		// 부분집합으로 A(0)를 넣을지 B(1)를 넣을지 분류하기
		if (k == sel.length) {
			// 원복 배열을 복사
			int[][] tmpFilm = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					tmpFilm[i][j] = film[i][j];
				}
			}
			// 약물 투여(0 또는 1로 해당 행 전부 변경
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < W; j++) {
					tmpFilm[arr[i]][j] = sel[i];
				}
			}

			if(checkCell(tmpFilm)) isDone = true;
			return;
		}
		// A로 선택한 경우
		sel[k] = 0;
		choiceAB(arr, sel, idx + 1, k + 1);
		// B로 선택한 경우
		sel[k] = 1;
		choiceAB(arr, sel, idx + 1, k + 1);
	}

	private static boolean checkCell(int[][] film) {
		pass = new int[W];

		//총 W번을 수행해야 함
		for (int j = 0; j < W; j++) {
			int tmp = 0;
			//위아래의 수를 비교
			for (int i = 0; i < D - 1; i++) {
				// 연속되는 숫자 개수 세기
				if (film[i][j] == film[i + 1][j]) {
					tmp++;
				} else {
					pass[j] = Math.max(tmp, pass[j]);
					tmp = 0;
				}
				pass[j] = Math.max(tmp, pass[j]);
			}
		}

		//System.out.println(Arrays.toString(pass));
		for (int cnt : pass) {
			if (cnt < K-1)	//일단 두개 비교해서 1을 올렸기 때문에 1이 모자란게 맞음
				return false;
		}
		return true;
	}
}
