package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1520_내리막길 {

	static int M,N,cnt=0;
	static int[][] map, memo;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map= new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo = new int[M][N];
		for(int[] m : memo) {
			Arrays.fill(m, -1);
		}
		System.out.println(dp(0,0));
//		for(int[] m : memo) {
//			System.out.println(Arrays.toString(m));
//		}
				
	}
	//탑다운 -> 다 갔다가 올라오면서 찍는다
	private static int dp(int r, int c) {
		if(r == M-1 && c ==N-1) {
			return 1;
		}
		//메모이제이션
		if(memo[r][c] != -1) return memo[r][c];
		//다녀오면 0으로 찍는다
		memo[r][c]=0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=M || nc<0 || nc>=N) continue;
			if(map[nr][nc] < map[r][c]) {
				//갔다가 돌아오는 애와 나의 값을 더한 값 vs 현재 내 값 비교
				memo[r][c] = Math.max(memo[r][c], dp(nr, nc)+memo[r][c]);				
			}
		}
		return memo[r][c];
	
	}
}
