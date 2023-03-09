/*
 * [BOJ]2178. 미로탐색 - bfs
 * 놓친 부분: bfs는 자기의 cnt를 가지고 다녀야 하므로 객체에 담아주어야 한다
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2178_미로탐색 {
	
	static class Point {
		int r,c,cnt;

		public Point(int r, int c,int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static int N,M, cnt=0;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		//최소칸 수로 이동 -> bfs
		bfs(0,0,1);
	}
	private static void bfs(int r, int c, int cnt) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, cnt));
		v[r][c] = true;

		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			System.out.println(p.r + " " + p.c);
			
			if(p.r == N-1 && p.c == M-1) {
				System.out.println(p.cnt);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(!v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.cnt+1));
				}
			}

		}
	
	}

}
