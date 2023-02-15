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
	static int T, N, X, max;
	static int[][] cheese;
	static boolean[][] eaten;
	static int day = 1;		//지난 날 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			eaten = new boolean[N][N];
			max=0;
			day=1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0,0);

			
		}
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cnt;	//덩어리 개수

	//날짜가 지날수록 먹어진 치즈부분이 누적됨
	private static void dfs(int r, int c, int cnt) {
		
		
		//basis part
		//다먹혔으면 리턴한다
		if() {
			return;
		}
		
		//inductive part
		
		//해당 일수가 적힌 치즈 부분을 먹었다고 처리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(day == cheese[i][j])
					eaten[i][j] = true;
			}
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			//가장자리 조건
			if(nr>=0 && nr<N && nc>=0 && nc<N && !eaten[nr][nc]) {
				//어젠 한 트리의 level 세어주기 ...
			}
		}
		
	}

}
