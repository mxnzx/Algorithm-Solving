package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추 {
	
	static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	

	static int T, M, N, K;
	
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());   
			N = Integer.parseInt(st.nextToken());	
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];  //행열 바뀌게 그냥 두고 할것임(상관없으므로)
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				map[p.x][p.y] = 1;
			}
			
			int cnt = 0; //구간 카운트 변수
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			
			
			
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
	}
	private static void bfs(int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		
		boolean[][] v = new boolean[M][N];
		q.offer(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();	//q를 빼서 넣는다
			map[p.x][p.y] = 0;	//지나온 곳을 0으로 바꾸어준다.
			
			for (int d = 0; d < 4; d++) {
				int nr ;
			}
			
			
			
		}
	}

}
