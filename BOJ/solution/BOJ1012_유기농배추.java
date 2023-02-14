/*
 * BOJ1012_유기농배추
 * BFS - 이런 땅따먹기 비슷한 문제들은 BFS를 떠올려보자
 * 막힌 부분: 평소알던 rc축이랑 반대여서 처음에 버벅거림 어차피 상관없는 문제니 그냥 풀었다
 * 나머지 구현은 빠르게 잘 했음
 * 델타 함수 사용 익숙해지기
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
		br.close();
		
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static void bfs(int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		
		boolean[][] v = new boolean[M][N];
		q.offer(new Point(x, y));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();	//q를 빼서 넣는다
			map[p.x][p.y] = 0;	//지나온 곳을 0으로 바꾸어준다.
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if(nx>=0 && nx<M && ny>=0 && ny < N && !v[nx][ny] && map[nx][ny] == 1) {
					q.offer(new Point(nx, ny));
					v[nx][ny] = true;
				}
			}

		}
	}

}
