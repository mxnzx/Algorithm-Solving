/*
 * [SWEA]1861. 정사각형방2 - DFS
 * 처음 수가 뭐여야 가장 많은 방 ?(여러개면 작은 수) -> 하나씩 다 확인해봐야됨 -> 완전 탐색 중 DFS 써보자
 * 막힌 부분: 방문 배열을 굳이 쓸 필요가 없음. 문제 조건을 잘 봐가면서 하기
 * 보충 필요한 문법: 재귀 이해 다시 하기
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class SWEA1861_정사각형방 {

	static int T, N, Ans, cnt; // 테케, N*N개 방, 최종 출력할 방번호, 한번돌때 방 최대 순회 방개수
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			Ans = N * N + 1; // 방 번호의 최댓값으로 초기화해줌

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt = 0;
			// 시작방을 하나씩 바꾸면서 완전탐색 수행
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1; // 시작방도 포함이니까 1부터 시작.
					count(i, j);

					// 탐색한 cnt와 이전(maxCnt)걸 비교한다.
					if(maxCnt <= cnt) {
						// 만약 순회한 방개수가 현재 맥스값과 같다면 방번호를 비교해서 더 작은 방번호를 넣는다.
						if(maxCnt == cnt) {
							Ans = Math.min(Ans, map[i][j]);
						} else {
							Ans = map[i][j];
						}
						maxCnt = cnt;
					}
				}
			}
			sb.append("#" + tc + " " + Ans + " " + maxCnt + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 사방탐색하면서 갈수 있으면 재귀를 통해 DFS를 수행하는 함수
	private static void count(int r, int c) {

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && (map[nr][nc] - map[r][c]) == 1) {
				cnt++;
				count(nr, nc);
			}
		}
	}
}
