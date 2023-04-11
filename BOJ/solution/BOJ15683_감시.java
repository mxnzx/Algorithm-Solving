package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15683_감시 {
	static class Point {
		int r,c,val;

		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int N,M, zeroCnt, ans;
	static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{0,1},{2,3}}, {{0,3}, {0,2}, {1,2}, {1,3}}, {{0,1,2}, {0,1,3}, {0,2,3},{1,2,3}}, {{0,1,2,3}}};
	static int[][] map;
	//                       북 남 서 동
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<Point> cctvList;
	
	public static void main(String[] args) throws IOException {
		//브루트 포스로 일단 다 구해봐야할듯.
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		zeroCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >0 && map[i][j] < 6) cctvList.add(new Point(i, j, map[i][j]));
				if(map[i][j] == 0) zeroCnt++; 
			}
		}
		//cctv가 비추는 곳을 9로 바꾼다
		//사각지대의 최소 크기 = '0'이었던 지역 - 9가 된 지역 
		//cctv 종류: 1 -> 4방향, 2-> 2방향, 3-> 4방향, 4-> 4방향 4번, 5 -> 1번 =>  이 방향 크기를 미리 정의
		
		//cctv 한방향을 잡고 늘릴 수 있는 만큼 늘린다. 씨씨티비를 다 돌때까지
		//그 다음 백트래킹으로 돌아와서 다음 방향을 수행한다
		// 다 채웠을 때마다 최솟값을 갱신한다
		ans = zeroCnt;
		watch(0, map);
	}

	//idx: cctv리스트 인덱스, tmpCnt 0->9로 바뀐 값
	private static void watch(int idx, int[][] map) {
		
		if(idx == cctvList.size()) {
			int zeroCnt=checkZero();
			ans = Math.min(ans, zeroCnt);
			return;
		}
		
		int cctvType = cctvList.get(idx).val;
		int r = cctvList.get(idx).r;
		int c = cctvList.get(idx).c;
		
		//맵 복사하여 사용
		for (int i = 0; i < mode[cctvType].length; i++) {
			int[][] tmpMap = new int[N][M];
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < M; j++) {
					tmpMap[k][j] = map[k][j];
				}
			}
			for (int j = 0; j < mode[cctvType][i].length; j++) {
				int d = mode[cctvType][i][j];
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				
			}
			
		}
		

		
	}

	private static int checkZero() {
		// TODO Auto-generated method stub
		return 0;
	}

}
