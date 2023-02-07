/*
 * BOJ15649. N과 M(2)
 * 재귀 - 순서 없는 조합
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
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
		
		recursive(og, new int[m], 0, 0);
		System.out.println(sb);

	}
	/*
	 * og : 원본배열
	 * sel : 선택배열
	 * idx = 원본배열 인덱스
	 * k = 선택배열 인덱스
	 */
	private static void recursive(int[] og, int[] sel, int idx, int k) {
		//basis part
		//전부 뽑은 경우
		if( k == sel.length) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		//더 이상 고를 값이 없는 경우
		if( idx == og.length)
			return;
		
		//inductive part
		
		//저장할 경우
		sel[k] = og[idx];
		recursive(og, sel, idx+1, k+1);
		//저장 안할 경우
		recursive(og, sel, idx+1, k);
		
	}

}
