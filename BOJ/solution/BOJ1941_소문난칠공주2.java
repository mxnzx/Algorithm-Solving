/*
 * 배열 복사할 때 얕은 복사로 하게 되면 원본 값도 바뀐다는 것 주의하자
 * 그냥 clone하삼
 * 문제 풀때 어떻게 풀지 다 생각하고 코드 써라 .. 헤매지않으려면
 */

package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941_소문난칠공주2 {

	static class Pos {
		int r, c;
		char val;

		public Pos(int r, int c, char val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", val=" + val + "]";
		}

	}

	static int res;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Pos> alist;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		v = new boolean[5][5];
		alist = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				alist.add(new Pos(i, j, map[i][j]));
			}
		}
		// dfs가 안됨 - 다시 되돌아가는 구조이므로
		// 25개라고 한정되어있으니까 25개 중에 7개를 뽑는다
		// 하고 나서 bfs나 서로소집합을 이용해 하나로 이어져있는지 확인한다
		// 그리고 S가 4개 이상인 지 확인
		comb(0, 0, new Pos[7]);
		System.out.println(res);
	}

	private static void comb(int idx, int k, Pos[] sel) {
		if (k == sel.length) {
			// 다솜이가 4명인지 먼저 체크  // 하나로 이어져있는지 체크 -> 둘다 true면 결과값 카운팅
			if (somCheck(sel) && isOnce(sel)) res++;
			return;
		}
		for (int i = idx; i < 25; i++) {
			sel[k] = alist.get(i);
			comb(i + 1, k + 1, sel);
		}
	}
	// 다솜이가 4명인지 체크
	private static boolean somCheck(Pos[] sel) {
		int cnt = 0;
		for (Pos p : sel) {
			if (p.val == 'S')
				cnt++;
			if (cnt >= 4) return true;
		}
		return false;
	}
	//한번에 이어져있나 체크
	private static boolean isOnce(Pos[] choiceArr) {
		//배열 복사해준다음에 선택해온 애들을 O로 바꿔준다
		char[][] checkMap = new char[5][5];
		for (int i = 0; i < 5; i++) {
			checkMap[i] = map[i].clone();
		}
		for (int i = 0; i < choiceArr.length; i++) {
			L: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (choiceArr[i].r == r && choiceArr[i].c == c) {
						checkMap[r][c] = 'O';
						break L;
					}
				}
			}
		}
		//O를 찾는 bfs를 돌린다
		boolean once = false;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (checkMap[i][j] == 'O') {
					once = bfs(checkMap, new Pos(i, j));
					break;
				}
			}
		}
		if (once)
			return true;
		return false;
	}
	
	private static boolean bfs(char[][] tmpMap, Pos start) {
		int cnt = 0;
		v = new boolean[5][5];
		Queue<Pos> q = new LinkedList<>();
		q.add(start);
		v[start.r][start.c] = true;
		cnt++;
		
		while (!q.isEmpty()) {
			Pos p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || v[nr][nc] || tmpMap[nr][nc] != 'O')continue;
				v[nr][nc] = true;
				q.add(new Pos(nr, nc));
				cnt++;
			}
		}
		//큐에 넣어진 개수가 7개면 7개가 다 이어져있다는 것임
		if (cnt == 7) return true;
		return false;
	}
}
