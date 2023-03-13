package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569_토마토 {

	static class Point {
		int r,c,h;

		public Point(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", h=" + h + "]";
		}
		
		
	}
					//위 아래 상  하  좌 우
	static int[] dr = {0,0,-1,1,0,0};
	static int[] dc = {0,0,0,0,-1,1};
	static int[] dh = {-1,1,0,0,0,0};
	
	static int M,N,H,cnt=0;
	static int[][][] map;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//가로
		N = Integer.parseInt(st.nextToken());	//세로
		H = Integer.parseInt(st.nextToken());	//높이

		map = new int[N][M][H];
		boolean flag = false;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i] == 1) {
						q.add(new Point(j,k,i));
					}
					if(map[j][k][i] == -1) flag=true;
				}
			}
		}
		//-1이 없다면 0 출력 후 아웃
		if(!flag) {
			System.out.println(0);
			System.exit(0);
		}
		
		bfs();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[j][k][i] == -1) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(cnt);
		
		
		
		
	}
	private static void bfs() {
		// 큐에 있는 원소들을 하나씩 넣으면서 너비 우선 탐색 실시

		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 6; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nh = p.h + dh[d];
				
				//조건 확인
				if(nr<0 || nr>=M || nc<0 || nc>=N || nh <0 || nh>=H || map[nr][nc][nh] == -1) continue;
				if(map[nr][nc][nh] == 0) {
					map[nr][nc][nh] = 1;
					q.add(new Point(nr, nc, nh));
				}
			}
			cnt++;
		}
		
	}
	private static void print(int[][][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(map[i][j][k]);
				}
				System.out.println();
			}
		}
	}

}
