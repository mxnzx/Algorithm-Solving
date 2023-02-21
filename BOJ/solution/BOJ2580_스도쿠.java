/*
 * 0을 우선 찾고. 스도쿠는 행과 열 그리고 내가 속한 3*3정사각형 구간을 고려
 */

package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2580_스도쿠 {

	static int[][] map = new int[10][10];
	static ArrayList<Point> emptyNode = new ArrayList<>();
	static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					emptyNode.add(new Point(i, j));
			}
		}
		 System.out.println(emptyNode);
		 //가장 처음에 넣은 0의 좌표를 넣어준다
		 num=0;
		 System.out.println((emptyNode.get(num).r+ " " +emptyNode.get(num).c));
		 sudoku(emptyNode.get(num).r, emptyNode.get(num).c);

	}


	private static void sudoku(int r, int c) {

		// 내가 있는 모든 열 체크 -> 없는 값 뽑아
		boolean[] vc = new boolean[10];
		for (int i = 1; i <= 9; i++) {
			if (map[r][i] > 0)
				vc[i] = true;

		}
		// System.out.println(Arrays.toString(vc));
		// 내가 있는 모든 행 체크 -> 없는 값 뽑아
		boolean[] vr = new boolean[10];
		for (int i = 1; i <= 9; i++) {
			if (map[i][c] > 0)
				vr[i] = true;
		}
		// System.out.println(Arrays.toString(vr));
		// 내가 있는 사각형 체크 -> 없는 값 뽑아
		boolean[] vmap = new boolean[10];
		int n = 1;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (map[i][j] > 0) {
					vmap[n] = true;
				}
				n++;
			}
		}
		// 현재 노드를 채울 수 있는 숫자들을 담을 리스트 생성
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 세 조건을 만족하는 숫자를 리스트에 담는다.
		for (int i = 1; i <= 9; i++) {
			if (!vc[i] && !vr[i] && !vmap[i]) {
				// 세 조건을 만족하는 숫자를 리스트에 담는다.
				list.add(i);
				// System.out.println("list "+ list);
			}
		}
		// 조건 1 : 돌다가 0은 남았는데 넣을 수 있는 값이 없어 -> 리턴
		System.out.println(list.size());
		if (list.size() == 0 && emptyNode.size() - 1 != num) {
			return;
		}

		// 기저 조건 : 0을 다 채웠다면 -> 그 스토쿠출력하고 리턴
		System.out.println(emptyNode.size() - 1);
		System.out.println(num);
		if (emptyNode.size() - 1 == num) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}

		// 값이 여러개면 하나를 넣고 다시 스도쿠를 부른다
		for (int i = 0; i < list.size(); i++) {
			map[r][c] = list.get(i);
			num++;
			sudoku(emptyNode.get(num).r, emptyNode.get(num).c);

		}

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
