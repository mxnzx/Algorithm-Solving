/*
 * BOJ15651. N과 M(3)
 * 재귀 - 
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {

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
		
		recursive(og, new int[m], 0);
		System.out.println(sb);

	}
	/*
	 * og : 원본배열
	 * sel : 선택배열
	 * idx = 선택배열 인덱스
	 */
	private static void recursive(int[] og, int[] sel, int idx) {
		
		//basis part
		if(idx == sel.length) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//inductive part
		for(int i = 0; i < og.length; i++) {
			sel[idx] = og[i];
			recursive(og, sel, idx+1);
		}
	}
	

}
