/*
 * [SWEA]3289. 서로소집합
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289_서로소집합 {
	static int T, n, m;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 집합 수
			m = Integer.parseInt(st.nextToken()); // 연산 수
			
			parents = new int[n+1];
			//make set
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				
			}

		}
		System.out.println(sb);

	}

}
