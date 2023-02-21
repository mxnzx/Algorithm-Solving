/*
 * [BOJ]2580. 스도쿠2
 * 백트래킹 - 일단  DFS처럼 쭉~~~~~ 간다. 근데 거기서 조건을 걸어준다
 * 그렇게 되면 가지치기를 통해 전체를 탐색하지 않고 간다.
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2580_스도쿠 {

	static int[][] map;
	static ArrayList<Point> list = new ArrayList<>();

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					// 0을 입력받으면 그 좌표값을 리스트에 넣어준다.
					list.add(new Point(i, j));
			}
		}
		// System.out.println(list.size());
		solve(0);

	}

	// k: 빈공간을 가진 좌표를 가진 배열 인덱스
	private static void solve(int k) {
		// basis part
		if (k == list.size()) {
			print(map);
			System.out.println(sb);
			System.exit(0);
		}

		// inductive part
		int r = list.get(k).r;
		int c = list.get(k).c;

		for (int i = 1; i <= 9; i++) {
			if (check(r, c, i)) {
				map[r][c] = i;
				solve(k + 1);
				map[r][c] = 0;
			}
		}

	}

	// 중복되는 값이 없다면 true리턴
	// num: 확인할 값
	private static boolean check(int r, int c, int num) {
		// TODO Auto-generated method stub
		//행과 열 체크
		for (int i = 0; i < 9; i++) {
			if(map[i][c] == num || map[r][i] == num) {
				return false;
			}
		}
		//내구간에서의 3*3배열 체크
		int nr = (r/3) * 3;
		int nc = (c/3) * 3;
		
		
		for (int i = nr; i < nr+3; i++) {
			for (int j = nc; j < nc+3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		
		return true;
	}

	private static void print(int[][] map) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
	}

}
