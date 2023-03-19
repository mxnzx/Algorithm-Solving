
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569_토마토 {

	static class Point {
		int r,c,h,cnt;

		public Point(int r, int c, int h, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
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
	
	static int M,N,H,finalCnt=0;
	static int[][][] map;
	static boolean[][][] v;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//가로
		N = Integer.parseInt(st.nextToken());	//세로
		H = Integer.parseInt(st.nextToken());	//높이

		map = new int[N][M][H];	//세로 가로 높이 순
		v = new boolean[N][M][H];
		boolean flag = false;	//익지 않은 토마토가 들어있나 확인하는 플래그
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i] == 1) {
						q.add(new Point(j,k,i,0));
						v[j][k][i] = true;
					}
					//익지 않은 토마토(0이 들어왔다면 true)
					if(!flag && map[j][k][i] == 0) flag=true;
				}
			}
		}
		//0이 없다면(=안익은토마토가 없다면) 0 출력 후 아웃
		if(!flag) {
			System.out.println(0);
			System.exit(0);
		}

		//돌면서 익는데 걸린 날짜로 해당 값을 변경한다
		bfs();

		//돌고 와서 0이 있다면(못 익은 토마토 존재) -1 출력
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[j][k][i] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(finalCnt);

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
				if(nr<0 || nr>=N || nc<0 || nc>=M || nh <0 || nh>=H || v[nr][nc][nh]) continue;
				//다음 토마토가 안 익은 토마토일때
				if(map[nr][nc][nh] == 0) {
					map[nr][nc][nh] = p.cnt+1;
					v[nr][nc][nh] = true;
					q.add(new Point(nr, nc, nh, map[nr][nc][nh]));
				}
				//현재 걸린 날짜 중 가장 큰 값을 구하도록 계속 업데이트 한다.
				finalCnt = Math.max(map[nr][nc][nh],finalCnt);
			}
			//print(map);
		}
		
	}
	private static void print(int[][][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(map[j][k][i]);
				}
				System.out.println();
			}
		}
		System.out.println();
	}

}
