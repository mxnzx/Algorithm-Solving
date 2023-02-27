/*
 * [SWEA]3289. 서로소집합 - 자료구조(그래프), 서로소집합
 * 막힌 부분: 교집합 찾는 부분에서 루트노드를 안구했었음
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
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(c == 0) {	//합집합 실행
					//union - find
					union(a,b);

				} else { //c=1 일때. 둘의 교집합 여부 확인 -> 루트노드를 찾아 교집합인지 확인해라
					int pa = find(a);
					int pb = find(b);
					if(pa == pb) {
						sb.append(1);
					} else sb.append(0);
				}
				
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if(pa != pb) {
			parents[pb] = parents[pa];
		}
	}
	private static int find(int og) {
		if(parents[og] == og) return og;
		else return parents[og] = find(parents[og]);
	}

}
