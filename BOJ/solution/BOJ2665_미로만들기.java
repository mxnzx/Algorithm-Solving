package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2665_미로만들기 {

	static int n, ans=0;
	static int[][] map, dist;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Point {
		int r,c,w;

		public Point(int r, int c,int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		public int getW() {
			return w;
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
		dist = new int[n][n];
		for(int[] d : dist) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;

		PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(Point::getW));
		pq.add(new Point(0, 0, 0));
		v[0][0] = true;

		int minDist;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			minDist = p.w;

			if(p.r == n-1 && p.c == n-1) {
				ans = minDist;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if(nr<0 || nr>= n || nc<0 || nc>=n || v[nr][nc]) continue;

				int next;
				if(map[nr][nc] == 0) next=1;	//다음이 벽이면 1의 값을 주자
				else next = 0;

				if(dist[nr][nc] > minDist + next) {
					dist[nr][nc] = minDist + next;
					v[nr][nc] = true;
					pq.add(new Point(nr,nc,dist[nr][nc]));
				}
			}
		}
		//출력
		System.out.println(ans);

	}

}
