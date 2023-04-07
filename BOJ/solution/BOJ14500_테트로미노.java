package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14500_테트로미노 {

	static class Pos {
		int r,c,sum,cnt;

		public Pos(int r, int c, int sum, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.sum= sum;
			this.cnt = cnt;
		}
		
	}
	static int N,M,max=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//전부 다~~해본다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(i,j,map[i][j],1);
				v[i][j] = false;
			}
		}
		System.out.println(max);

	}

	private static void dfs(int r, int c, int sum, int cnt) {
		if(cnt==4) {
			if(max < sum) {
				max = sum;				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(v[i][j] + "\t");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]) continue;
			
			v[nr][nc] = true;
			//ㅗ추출   //가지 않고 한번 더 넣는다 오 ,... 
			if(cnt==2) dfs(r, c, sum+map[nr][nc], cnt+1);
							
			dfs(nr, nc, sum+map[nr][nc], cnt+1);
			v[nr][nc] = false;
		}
		
	}

}
