/* [BOJ]1261. 알고스팟
 * 다익스트라 !!! 2차원배열에서는 사방탐색처럼 생각하면 된다. 클래스를 해당 행, 열, 가중치(값)으로 두면 됨~
 */
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

		@Override
		public String toString() {
			return "Point{" +
					"r=" + r +
					", c=" + c +
					", weight=" + weight +
					'}';
		}
	}
	static int N,M;
	static int[][] map;
	static int[][] dist;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//가로
		N = Integer.parseInt(st.nextToken());	//세로

		map = new int[N][M];
		v = new boolean[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		//가중치가 있음 - 0이거나 1이거나
		// 결국은 최대한 0을 택하고 안되면 1을 택하게 한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = 0;

		PriorityQueue<Point> q= new PriorityQueue<>(Comparator.comparing(Point::getWeight));
		q.add(new Point(0, 0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int minR = p.r;
			int minC = p.c;
			int minDist = p.weight;
			v[p.r][p.c] = true;
			//도착점에 도착하면 최소비용을 출력하고 종료.
			if(p.r == N-1 && p.c == M-1) {
				System.out.println(minDist);
				break;
			}
			//사방탐색을 하면서 더 작은 곳으로 이동
			for (int d = 0; d < 4; d++) {
				int nr = minR + dr[d];
				int nc = minC + dc[d];

				if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]) continue;
				int nw = map[nr][nc];

				//더 작은 값으로 간다
				if(dist[nr][nc] > minDist + nw) {
					dist[nr][nc] = minDist + nw;
					q.add(new Point(nr,nc,dist[nr][nc]));
				}
			}
		}
		
	}

}
