import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
	static boolean isDone= false;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		//BFS
		//다음 시간에 물이 차오를 곳과 돌이 있는 곳 빼고 이동이 가능하게 함
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D')  D = new Point(i, j, 0,map[i][j]);
				if(map[i][j] == 'S')  S = new Point(i, j, 0,map[i][j]);
				if(map[i][j] == '*') q.add(new Point(i, j, map[i][j]));
			}
		}
		bfs();
		if(isDone) System.out.println(time);
		else System.out.println("KAKTUS");
	}

	private static void bfs() {

		q.add(S);
		v[S.r][S.c]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
		
			//도착했을 때
			if(p.r == D.r && p.c == D.c) {
				isDone = true;
				time = p.time;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				//물일 때 - 먼저 큐에 넣는다 ->고슴도치가 움직일 때 이미 바뀌어 있음!
				if(p.val == '*' && !v[nr][nc] && map[nr][nc] != 'D' && map[nr][nc] != 'X') {
					map[nr][nc] = '*';
					q.add(new Point(nr, nc,map[nr][nc],'*'));
					//이걸 빼면 메모리 초과됨..
					v[nr][nc] = true;		
				}

				//고슴도치일때
				if(p.val == 'S' 	&& !v[nr][nc] && map[nr][nc] != 'X' && map[nr][nc] != '*')  {
//					System.out.println(nr+" "+nc);
					q.add(new Point(nr, nc, p.time+1,'S'));
					v[nr][nc] = true;		
				}

			}
		}
	}


}
