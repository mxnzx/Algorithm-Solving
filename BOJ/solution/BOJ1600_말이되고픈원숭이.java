/*
 * [BOJ]1600. 말이되고픈원숭이 - bfs
 * 체크포인트: 3차원 방문배열 - 말처럼 이동할 때마다 방문배열을 다르게 쓴다. 말처럼 이동했을 때 카운트도 함께 해준다 -> int 배열로 선언
 * 유사문제 : 벽부수고이동하기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {
	static  class Point {
		int r;
		int c;
		int cnt;
		int horse;

		public Point(int r, int c, int cnt, int horse) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.horse = horse;
		}
	}
	static int K,W,H;
	static int[][] map;
	static int[][][] v;
	static int[][] dr= {{-1,1,0,0}, {-1,-2,-2,-1,1,2,2,1}};
	static int[][] dc= {{0,0,-1,1}, {-2,-1,1,2,2,1,-1,-2}};
	static boolean isDone=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//말숭이가 언제 나이트 이동방식을 쓸 것인가? 쓰고 가기 / 안쓰고 가기 -> 다른 방문배열을 사용해야 함
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//3차원 배열 -> 인덱스 1부터 썼으면 true 안썼으면 false
		v = new int[H][W][K+1];
		//동작 수의 최솟값 -> bfs
		bfs();
		if(!isDone) {
			System.out.println(-1);
		}
		
		
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0,0));
		v[0][0][0] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if(p.r == H-1 && p.c == W-1) {
				System.out.println(p.cnt);
				isDone = true;
				return;
			}

			//말처럼 이동하기 -> 가능하다는 전제조건
			if(p.horse < K) {
				for (int d = 0; d < 8; d++) {
					int nr = p.r + dr[1][d];
					int nc = p.c + dc[1][d];
					int nhorse = p.horse+1;

					if(nr<0 || nr>=H || nc<0 || nc>=W || v[nr][nc][nhorse]==1 || map[nr][nc] == 1) continue;
					q.add(new Point(nr,nc,p.cnt+1,nhorse));
					v[nr][nc][nhorse] = 1;
				}
			}
			//그냥 이동하기
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[0][d];
				int nc = p.c + dc[0][d];
				int nhorse = p.horse;

				if(nr<0 || nr>=H || nc<0 || nc>=W || v[nr][nc][nhorse]==1 || map[nr][nc] == 1) continue;
				q.add(new Point(nr,nc,p.cnt+1,nhorse));
				v[nr][nc][nhorse] = 1;
			}

		}
	}

}
