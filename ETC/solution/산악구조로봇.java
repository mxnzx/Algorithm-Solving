/*
 * 산악구조로봇 - 다익스트라
 * 2차원배열로 사방탐색으로 하면서 + 가중치 경우의 수가 3개니까 각각 해주면 된다
 */
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 산악구조로봇 {
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
	static int T, N, Ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map, dist;
	static boolean[][] v;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("ETC/input/산악구조로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N+1][N+1];
			v = new boolean[N+1][N+1];
			dist = new int[N+1][N+1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//다익스트라
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dist[i], INF);
			}
			dist[1][1] = 0;
			PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing(Point::getWeight));
			q.add(new Point(1,1,0));

			while (!q.isEmpty()) {
				Point p = q.poll();
				int minR = p.r;
				int minC = p.c;
				int minDist = p.weight;
				v[minR][minC] = true;

				//도착지점에 가면 탈출
				if(minR == N && minC == N) {
					Ans = minDist;
					break;
				}

				//사방탐색을 하면서 간다
				for (int d = 0; d < 4; d++) {
					int nr = minR + dr[d];
					int nc = minC + dc[d];
					if(nr<=0 || nr>N || nc<=0 || nc>N) continue;

					//가중치가 더해지는 경우가 세가지.
					int nw;
					//1. 나보다 낮은 곳을 갈때 (nw = 0)
					if(map[nr][nc] < map[minR][minC]) {
						nw = 0;
					} else if (map[nr][nc] == map[minR][minC]) { //2. 나와 같은 곳을 갈때 (nw = 1)
						nw = 1;
					} else { //3. 나보다 높은 곳을 갈때 (nw = 높이차*2)
						nw = (map[nr][nc] - map[minR][minC])*2;
					}

					if(!v[nr][nc] && dist[nr][nc] > minDist + nw) {
						dist[nr][nc] = minDist + nw;
						q.add(new Point(nr,nc,dist[nr][nc]));
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(Ans).append("\n");
		}
		System.out.println(sb);
	}

}
