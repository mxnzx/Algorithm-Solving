package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA4193_수영대회 {

	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int T, N, min;
	static boolean isDone=false;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	static Point start,end;	//시작지점, 끝지점
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		//최단경로 -> BFS?
		//소용돌이 ->  cnt를 통해 생길 때와 안 생길 때를 구분한다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v=new boolean[N][N];
			min=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));		//시작점
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));		//도착점
			
			v[start.r][start.c] = true;
			dfs(start,0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		
			System.out.println();
			
		}
		System.out.println(sb);
		
	}

	private static void dfs(Point p, int cnt) {

		//기저조건
		if(p.r == end.r && p.c == end.c) {
			min = Math.min(min, cnt);
			return;
		}
		
		for (int d = 0; d < 5; d++) {
			int nr = p.r + dr[d];
			int nc = p.c + dc[d];
			if(nr<0 || nr>= N || nc<0 || nc>= N || v[nr][nc] || map[nr][nc] == 1) continue;

			//cnt가 2 5 8  .. => cnt % 3 == 2 일때 map[][]==2 도 통과할 수 있음 -> 반대인 경우를 넘긴다 
			if(cnt % 3 != 2 && map[nr][nc] == 2) continue;
			
			System.out.println(p.r + " " + p.c + " =>" +cnt);
			//map[nr][nc] == 0 이거나 cnt%3이 2일 때 맵값이 2인 애들만 넘어온다
			//여기서 첫번째테케 cnt=2 일때 타야되는데 안타고 컨티뉴됨 왜 ?????????????
			if(cnt % 3 == 2 && map[nr][nc]==2) System.out.println("aa" + cnt); 
			v[nr][nc] = true;
			dfs(new Point(nr, nc),cnt+1);
			v[nr][nc] = false;
		}
		
		
		
		
	}

}
