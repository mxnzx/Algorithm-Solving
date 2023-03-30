package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N,M;
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
	}
	//3개 고른다
	private static void backtracking(int idx, int cnt) {
		
		if(cnt == 3) {
			checkMax();
			return;
		}
		//현재 0
		Point p = new Point(zeroList.get(idx).r, zeroList.get(idx).r);
		//고른경우
		map[p.r][p.c] = 1;
		backtracking(idx+1, cnt+1);
		map[p.r][p.c] = 0;

		//안고른경
		backtracking(idx+1, cnt);
		
	}

	private static void checkMax() {
		// TODO Auto-generated method stub
		
	}

}
