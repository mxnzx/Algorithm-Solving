/*
 * [SWEA]7465. 창용마을
 * 서로소 집합
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7465_창용마을 {
	static int T, N, M, cnt;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 사람 수
			M = Integer.parseInt(st.nextToken());   // 관계 수
			
			//서로소 집합  - make set
			parents = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			for (int i = 1; i < parents.length; i++) {
				if(parents[i] == i) cnt++;
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");

		}
		System.out.println(sb);

	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			parents[pa] = parents[pb];
		}
	}

	private static int find(int org) {
		if(parents[org] == org) return org;
		else return parents[org] = find(parents[org]);
	}

}
