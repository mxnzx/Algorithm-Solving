package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683_감시 {
	static class Point {
		int r, c, val;

		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}

	static int N, M, ans;
	static int[][] map;
	//    										북 남 서 동                   동 서 남 북 /     		    북동 동남 남서 서북/ 				/서북동 북동남 동남서 남서북 				/ 북남서동
	static int[][][] dr = { {}, { { -1 }, { 1 }, { 0 }, { 0 } }, { { 0, 0 }, { 1, -1 } }, { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, { { 0, -1, 0 }, { -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1 } }, { { -1, 1, 0, 0 } } };
	static int[][][] dc = { {}, { { 0 }, { 0 }, { -1 }, { 1 } }, { { 1, -1 }, { 0, 0 } }, { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }, { { -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1 }, { 0, -1, 0 } }, { { 0, 0, -1, 1 } } };
	static ArrayList<Point> cctvList;

	public static void main(String[] args) throws IOException {
		// 브루트 포스로 일단 다 구해봐야할듯.
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = Integer.MAX_VALUE;
		cctvList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					cctvList.add(new Point(i, j, map[i][j]));
			}
		}
		// cctv가 비추는 곳을 9로 바꾼다
		// cctv 한방향을 잡고 늘릴 수 있는 만큼 늘린다. 씨씨티비를 다 돌때까지
		// 그 다음 백트래킹으로 돌아와서 다음 방향을 수행한다
		// 다 채웠을 때마다 최솟값을 갱신한다
		watch(0, map);
		System.out.println(ans);
	}

	// idx: cctv리스트 인덱스, tmpCnt 0->9로 바뀐 값
	private static void watch(int idx, int[][] map) {

		if(idx == cctvList.size()) {
			int tmpCnt = checkZero(map);
			ans = Math.min(ans, tmpCnt);
			//print(map);
			return;
		}
		
		int[][] copyMap = new int[N][M];
		// 씨씨티비의 타입을 가져온다
		int type = cctvList.get(idx).val;
		int r = cctvList.get(idx).r;
		int c = cctvList.get(idx).c;

		for (int j = 0; j < dr[type].length; j++) {
			//내가 복사해온 지도를 가지고 내가 그을 수 있을때까지 긋는다
			for (int n = 0; n < N; n++) {
				copyMap[n] = map[n].clone();
			}
			//내가 갈 방향을 하나 정한다
			for (int k = 0; k < dr[type][j].length; k++) {
				int nr = r;
				int nc = c;
				//그을 수 있을때까지 긋는다.
				while (true) {
					//쭉쭉 내보낼때는 이렇게 그으면 된다. . . 알아두기
					nr += dr[type][j][k];
					nc += dc[type][j][k];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 6) break;
					// 다음이 씨씨티비라면 값을 바꾸지 않고 dfs
					// 0이라면 9로 바꾸고 dfs
					if (copyMap[nr][nc] == 0) copyMap[nr][nc] = 9;
				}
			}
			watch(idx + 1, copyMap);
			//여기서 리턴 맞아서 돌아오면 map은 그 당시의 맵으로 사용된다.
		}
	}

	private static int checkZero(int[][] map) {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	private static void print(int[][] map) {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
