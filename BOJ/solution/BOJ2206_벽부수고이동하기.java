/*
 * [BOJ]2206. 벽부수고이동하기 - 방문배열이 3차원인 BFS
 * 막힌 과정: DFS로 풀면서 flag을 두었더니 시간초과 뜸
 * 내가 어떤 플래그를 가지고 BFS탐색을 할때에는 플래그 상태에 따라 방문처리를 다르게 해야하므로 기존의 2차원이 아닌 3차원으로 두어야 하는 문제이다.
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {
	static class Node {
		int r, c, cnt, isBroken;

		Node(int r, int c, int cnt, int isBroken) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.isBroken = isBroken;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0, 0));

	}

	private static int bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c,1, 0));
		visited[r][c][0] = true;
		while(!q.isEmpty()) {
			Node current = q.poll();

			if(current.r==N-1 && current.c == M-1) return current.cnt;

			for (int d = 0; d < 4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=N || nc<0 || nc >= M || visited[nr][nc][current.isBroken]) continue;

				if(map[nr][nc] == 0) {
					q.add(new Node(nr, nc, current.cnt+1, current.isBroken));
					visited[nr][nc][current.isBroken] = true;
				}
				if(current.isBroken == 0 && map[nr][nc] == 1) {
					q.add(new Node(nr, nc, current.cnt+1, 1));
					visited[nr][nc][1] = true;
				}
			}
		}
		return -1;
	}
}
