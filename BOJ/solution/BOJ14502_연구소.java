package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	static int N,M,res=-1;
	static int[][] map;
	static boolean[][] v;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static ArrayList<Point> zeroList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//0중에 3개 골라 놓고 확인 -> max값 갱신
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					zeroList.add(new Point(i,j));
				}
			}
		}
		//0인 애들을 찾아서 리스트에 저장. 걔를 빼면서 놓을래 안놓을래 -> 재귀 cnt=3 되면 checkMax
		backtracking(0, 0);
		System.out.println(res);

	}
	//3개 고른다
	private static void backtracking(int idx, int cnt) {
		
		//3개 다 뽑은 경우
		if(cnt == 3) {
			//print(map);
			checkMax();
			return;
		}
		//다 뽑지 않고 리스트를 다 돈 경우
		if(idx == zeroList.size()) {
			return;
		}
		//현재 0
		Point p = zeroList.get(idx);
		//고른경우
		map[p.r][p.c] = 1;
		backtracking(idx+1, cnt+1);
		map[p.r][p.c] = 0;
		//안고른경우
		backtracking(idx+1, cnt);
		
	}

	private static void checkMax() {
		//지도에서 2를 타고 갈수 있는데까지 2를 채운다
		v = new boolean[N][M];
		//배열복사
		int[][] tmpMap = new int[N][M];	
		for(int i = 0; i <N; i++) {
			for(int j = 0; j < M; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//방문조건 잘 처리하기 -> 중복 방지
				if(tmpMap[i][j] == 2 && !v[i][j]) {
					v[i][j]=true;
					dfs(new Point(i, j),tmpMap);
					//bfs(new Point(i, j),tmpMap);
				}
			}
		}
		//안전영역(0)이 몇개 있는지 비교한다
		int tmp=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmpMap[i][j] == 0) {
					tmp++;
				}
			}
		}
		res = Math.max(tmp, res);
		
	}
	
	private static void dfs(Point p, int[][] tmpMap) {
		
		for (int d = 0; d < 4; d++) {
			int nr = p.r + dr[d];
			int nc = p.c + dc[d];
			if(nr<0 || nr>= N || nc<0 || nc>= M || v[nr][nc]) continue;
			if(tmpMap[nr][nc] == 0) {
				v[nr][nc] = true;
				tmpMap[nr][nc]=2;
				dfs(new Point(nr, nc), tmpMap);
				//들어갔다가 다시 돌아올 필요가 없다 -> 어차피 한길로만 가므로?
			}
		}
	}
	//시간, 메모리 dfs보다 많이 먹음. DFS에서 돌아왔을때 방문 해제를 할 필요가 없어서 저게 더 메모리시간관리에 효율적임
	private static void bfs(Point start, int[][] tmpMap) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		v[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr<0 || nr>= N || nc<0 || nc>= M || v[nr][nc]) continue;
				if(tmpMap[nr][nc] != 1) {
					v[nr][nc] = true;
					tmpMap[nr][nc]=2;
					q.add(new Point(nr, nc));
				}
			}
		}
	}



}
