//오늘 주신 문제랑 완전 비슷
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1261_알고스팟 {
	
	static class Point {
		int r,c,weight;

		public Point(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}
		
	}
	static int N,M;
	static int[][] map;
	static int[] dist;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//세로
		M = Integer.parseInt(st.nextToken());	//가로
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가중치가 있음 - 0이거나 1이거나
		PriorityQueue<Point> q= new PriorityQueue<>(Comparator.comparing(Point::getWeight));
		q.add(new Point(0, 0, 0));
		
		while(!q.isEmpty()) {
			
		}
		
	}

}
