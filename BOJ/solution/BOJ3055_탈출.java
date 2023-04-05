//BFS - 가지치기 잘 하자!!!!!!! 조건 꼼꼼하게 달기

package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055_탈출 {
	static class Point {
		int r,c, time;
		char val;

		public Point(int r, int c, int time, char val) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.val = val;
		}

		public Point(int r, int c, char val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R,C,time;
	static char[][] map;
	static boolean[][] v;
	static Point D,S;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		//BFS
		//다음 시간에 물이 차오를 곳과 돌이 있는 곳 빼고 이동이 가능하게 함
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
        time=0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D')  D = new Point(i, j, 'D');
				if(map[i][j] == 'S')  S = new Point(i, j, 'S');
				if(map[i][j] == '*') q.add(new Point(i, j, '*'));
			}
		}
		time = bfs();
        if(time != 0) System.out.println(time);
		else System.out.println("KAKTUS");
	}

	private static int bfs() {
		q.add(S);
		v[S.r][S.c]=true;

		while(!q.isEmpty()) {
			Point p = q.poll();

			//도착했을 때
			if(p.r == D.r && p.c == D.c) return p.time;

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				//물일 때 - 먼저 큐에 넣는다 ->고슴도치가 움직일 때 이미 바뀌어 있음! - 다음이 돌도 아니고 도착도 아니고 물도 아니면(중복방지)
				if(p.val == '*' && map[nr][nc] != 'D' && map[nr][nc] != 'X' && map[nr][nc] != '*') {
					map[nr][nc] = '*';
					q.add(new Point(nr, nc,'*'));
				}
				//고슴도치일때
				if(p.val == 'S' && !v[nr][nc] && map[nr][nc] != 'X' && map[nr][nc] != '*')  {
					q.add(new Point(nr, nc, p.time+1,'S'));
					v[nr][nc] = true;
				}

			}
		}
        return 0;
	}


}
