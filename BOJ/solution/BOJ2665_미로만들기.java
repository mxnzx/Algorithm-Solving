package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2665_미로만들기 {

	static int n;
	static int[][] map, dist;
	static boolean[][] v;
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// 가면서 1이 (0,0) -> (N-1,N-1) 까지 한번에 갈 수 있는지 볼거다
		// 갈수없다면 0을가는데 cost를 증가시킨다
		// 가는데 비용이 든다 -> 0을 가는 경우 +1 -> 다익스트라로 최소비용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		//다익스트라 실행
		v = new boolean[n][n];
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0));
		v[0][0] = true;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			Point minNode = p;
			int mindist = 0;
			
			
			
		}
		
		

	}

}
