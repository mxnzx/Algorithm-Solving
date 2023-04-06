//구현
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA2382_미생물 {

	static class Pos {
		int idx, r, c, cnt, dir;

		public Pos(int idx, int r, int c, int cnt, int dir) {
			super();
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir; // 상(1) 하(2) 좌(3) 우(4)
		}

		@Override
		public String toString() {
			return "Pos [idx=" + idx + ", r=" + r + ", c=" + c + ", cnt=" + cnt + ", dir=" + dir + "]";
		}

	}

	static int T, N, M, K;
	static ArrayList<Pos>[][] map;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Pos> microbe;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수

			map = new ArrayList[N][N]; // 맵을 배열리스트로 만든다. 안에는 하나만 있어야 됨. 2개이상일때 합치자
			//배열리스트 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new ArrayList<Pos>();
				}
			}
			microbe = new ArrayList<>();		//미생물 리스트는 반복문을 돌릴때와 마지막에 미생물의 개수 추출시 사용할것임
			int r, c, cnt, dir;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				cnt = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				microbe.add(new Pos(i + 1, r, c, cnt, dir)); // 리스트에 담는다
				map[r][c].add(microbe.get(i)); // 맵에 미생물 객체추가
			}

			// M번 진행한다
			for (int i = 0; i < M; i++) {
				// 미생물을 0번부터 차례대로 이동시킨다
				for (Pos m : microbe) {
					int nr = m.r + dr[m.dir];
					int nc = m.c + dc[m.dir];

					map[m.r][m.c].remove(0); // 맵의 기존위치의 객체를 제거하고 일단 모두 이동시킨다
					m.r += dr[m.dir];
					m.c += dc[m.dir];
					// 맵에서 다음이동한 자리에 객체를 추가
					map[nr][nc].add(m);

					// System.out.println(Arrays.deepToString(map));

					// 다음이 가장자리일 때 - 이동하고 미생물(cnt)이 반이 사라지고 방향이 상<->하, 좌<->우로 바뀐다
					if (isEdge(nr, nc)) {
						m.cnt /= 2;
						m.dir = changeDir(m.dir);
					}
				}

				// 전부 이동시키고 나서 같은 칸에 있는 애들이 있는지 체크
				for (int r1 = 0; r1 < N; r1++) {
					for (int c1 = 0; c1 < N; c1++) {
						if (map[r1][c1].size() > 1) {
							//하나이상이면 합친다
							union(map[r1][c1]);
							// 이전애들삭제하고 넣는다
							map[r1][c1].clear();
							map[r1][c1].add(microbe.get(microbe.size() - 1));
						}
					}
				}
			}
			// 남아있는 미생물 수 세기
			int sum = 0;
			for (Pos m : microbe) {
				sum += m.cnt;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);

	}

	private static void union(ArrayList<Pos> cluster) {
		// 비교해서 cnt는 합치고 방향을 하나로 합친다(기존 cnt가 가장 컸던 미생물의 것으로)
		int r = cluster.get(0).r;
		int c = cluster.get(0).c;
		int maxCnt = 0, maxIdx = -1, maxDir = 0, sumCnt = 0;
		for (int i = 0; i < cluster.size(); i++) {
			//미생물리스트에서 현재 합칠 객체들을 전부 삭제한다. 우리는 새로 만든 미생물객체를 리스트 맨 뒤에 추가할 것임(이 순서는 맵과 무관하므로)
			microbe.remove(cluster.get(i));
			int tmpCnt = cluster.get(i).cnt;
			if (maxCnt < tmpCnt) {
				maxCnt = tmpCnt;
				maxIdx = cluster.get(i).idx;
				maxDir = cluster.get(i).dir;
			}
			sumCnt += tmpCnt;
		}

		microbe.add(new Pos(maxIdx, r, c, sumCnt, maxDir));

	}

	//방향을 바꾸는 메서드
	private static int changeDir(int dir) {
		if (dir == 1)
			return 2;
		if (dir == 2)
			return 1;
		if (dir == 3)
			return 4;
		if (dir == 4)
			return 3;
		return 0;
	}

	//가장자리인지 확인하는 메서드
	private static boolean isEdge(int r, int c) {
		if (r == 0 || r == N - 1 || c == 0 || c == N - 1)
			return true;
		return false;
	}

}
