/*
 * BOJ15649. N과 M (1)
 * 재귀
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); // 선택된 배열 길이

		// 원본 배열 생성
		int[] og = new int[n];
		for (int i = 0; i < n; i++) {
			og[i] = i + 1;
		}

		recursive(og, new int[m], 0, new boolean[og.length]);
		System.out.println(sb);

	}

	private static void recursive(int[] og, int[] sel, int idx, boolean[] isSelected) {
		// basis part
		if (sel.length == idx) {

			// 출력 형태 맞추기
			// System.out.println(Arrays.toString(sel));
			for (int j = 0; j < sel.length; j++) {
				sb.append(sel[j]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// inductive part
		for (int i = 0; i < og.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				sel[idx] = og[i];
				recursive(og, sel, idx + 1, isSelected);
				isSelected[i] = false;
			}
		}

	}

}
