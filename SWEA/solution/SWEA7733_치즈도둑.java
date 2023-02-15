/*
 * [SWEA]7733. 치즈도둑
 *
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7733_치즈도둑 {
	static int T, N, max, cnt;
	static int[][] cheese;
	static boolean[][] eaten, v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			eaten = new boolean[N][N];  //먹었는지
			v = new boolean[N][N];		//방문배열
			max=0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			for (int d = 0; d <= 100; d++) {
				cnt=0;
				//해당 일수가 적힌 치즈 부분을 먹었다고 처리
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(d == cheese[i][j]) {
							eaten[i][j] = true;
						}
					}
				}
				//방문도 하지 않았고, 먹히지 않은 곳을 탐색
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!v[i][j] && !eaten[i][j]) {
							dfs(i,j);
							cnt++;
						}
					}
				}
				max = Math.max(max, cnt);

			}


			sb.append("#" + tc + " " + max + "\n");

		}
		System.out.println(sb);
		br.close();
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	private static class Point {
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	//날짜가 지날수록 먹어진 치즈부분이 누적됨 - 구현: 스택
	private static void dfs(int r, int c) {

		v[r][c] = true;
		Point p = new Point(r,c);


			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && !eaten[nr][nc]) {
					dfs(nr,nc);
				}
			}


	}

}
