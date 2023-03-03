package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 산악구조로봇 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int T, N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("ETC/input/산악구조로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N+1][N+1];
			v = new boolean[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//print(map);
			//최소 연료 소비 경로 - 나와 거리가 최소인애를 찾아간다 -> 없으면 백트래킹 - dfs
			// 목적지에 도달을 안했는데 없으면 그 중 가장 작은 길을 간다?
			
			
			
			
		}
	}
	
	private static void print(int[][] map) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
