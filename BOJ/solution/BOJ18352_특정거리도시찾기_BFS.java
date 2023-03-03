/*
 * [BOJ]18352. 특정거리도시찾기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352_특정거리도시찾기_BFS {

	static int N, M, K, X;
	static ArrayList<Integer>[] adjList;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시개수
		M = Integer.parseInt(st.nextToken()); // 도로개수(간선수)
		K = Integer.parseInt(st.nextToken()); // 주어진 최단거리
		X = Integer.parseInt(st.nextToken()); // 출발도시번호
		dist = new int[N + 1];
		// 인접 리스트 생성
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		// 다익스트라
		// 가지 않은 거리들을 -1로 초기화한다. -> 방문배열처럼 사용할 것이다
		Arrays.fill(dist, -1);
		dist[X] = 0; // 처음 시작점 0으로 둔다.

		Queue<Integer> q = new LinkedList<>();
		q.add(X);

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int next : adjList[p]) {
				// 시작점부터 타고 내려오는데 제일 먼저 들어왔다면 이게 최단거리(가중치가 없으므로) => BFS
				if (dist[next] == -1) {
					dist[next] = dist[p] + 1;
					q.add(next);
				}
			}
		}
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i).append("\n");
				flag = true;
			}
		}
		if (flag)
			System.out.println(sb);
		else
			System.out.println(-1);

	}

}
