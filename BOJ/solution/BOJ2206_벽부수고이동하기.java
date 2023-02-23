package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {

	static int N, M, Ans;
	static int[][] map;
	static boolean[][] v; // 방문배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean flag = false; // 벽 부수었는지 플래그

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		Ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		// 0이 이동 가능 1이 벽
		// 최단경로? BFS?
		// 중간에 벽 하나 부실 수 있다 -> 뭘 부실래? 몰라 ! 하나씩 다 해봐 -> DFS? -> 시간초과뜸
		v[0][0] = true;
		dfs(0, 0, 1);
		if (Ans == Integer.MAX_VALUE)
			Ans = -1;
		System.out.println(Ans);
	}
	
	//방문배열을 두개써서 푼 경우(벽을 부수고 부터는 방문배열을 교체한다
	private static void bfs() {
		
		
		
	}
	
	
	
	
	
	

	//시간 초과 남
	private static void dfs(int r, int c, int cnt) {

		if (r == N - 1 && c == M - 1) {
			Ans = Math.min(Ans, cnt);

			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			//이미 벽을 부수었다면
			if (flag) {

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || map[nr][nc] == 1)
					continue;

				v[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				v[nr][nc] = false;

			}
			// 내가 아직 벽을 부술 수 있다면
			else {
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc]) continue;
				//벽을 0으로 바꿈
				map[nr][nc] = 0;
				flag = true;

				v[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				v[nr][nc] = false;
				flag = false;

			}

		}

	}

}
