package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {

	static int N,M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//0중에 3개 골라 놓고 확인 -> max값 갱신
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtracking(0,0);
	}

	private static void backtracking(int r, int c) {
		
		if(r == N-1 && c == M-1) {
			checkMax();
			return;
		}
		
	}

	private static void checkMax() {
		// TODO Auto-generated method stub
		
	}

}
