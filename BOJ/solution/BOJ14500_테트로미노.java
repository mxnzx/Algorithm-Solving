package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500_테트로미노 {

	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				// 브루트포스 - dfs
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				//해당 풀이가 떠오르지 않는다면, 아예 여기서 따로 comb 하나 더 먹이고 3개 찾아와도 됨. 별차이 없음.
			}
		}
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt, int sum) {

		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			//뻐큐 고려 - 현재 칸(r,c)에서 하나 더 선택한다
			if (cnt == 2) dfs(r, c, cnt + 1, sum + map[nr][nc]);
			dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
	}
}
