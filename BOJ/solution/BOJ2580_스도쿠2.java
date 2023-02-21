
package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ2580_스도쿠2 {
	static int[][] map;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Point(i, j));
			}
		}
		// System.out.println(list.size());
		// print(map);
		solve(0);
	}

	// k : 빈좌표 index
	private static void solve(int k) {
		// basis part
		if (k == list.size()) {
			print(map);
			;
		}

		// inductive part
		int r = list.get(k).r;
		int c = list.get(k).c;

		for (int i = 1; i <= 9; i++) {
			// 가지치기
			if (check(r, c, i)) {
				map[r][c] = i;
				solve(k + 1);
				map[r][c] = 0;
			}

		}
	}

	// 중복되는 값이 없으면 true;
	// 아니면 false;
	private static boolean check(int r, int c, int num) {

		// 모든 열 체크
		for (int i = 0; i <9; i++) {
			if (map[r][i] == num)
				return false;
		}
		// 내가 있는 모든 행 체크
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == num)
				return false;
		}
		// 내가 있는 사각형 체크
		int nr = (r / 3) * 3 ;
		int nc = (c / 3) * 3 ;
		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if (map[i][j] == num) {
					return false;
				}
			}
		}

		return true;

	}

	private static void print(int[][] map) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
