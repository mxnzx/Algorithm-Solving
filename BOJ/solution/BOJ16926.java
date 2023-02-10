/*
 * BOJ16926. 배열돌리기1
 * 구현 - 2차원 배열. 델타 이용
 * 놓친 부분 - 가장자리 조건 설정 오류. 논리연산자 제대로 쓰기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {

	static int[][] arr; // 사용 배열
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 A의 크기 N, M. 시작점(1,1), 회전 연산 수 = K
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		// 2차원 배열 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < R; k++) {
			for (int c = 0; c < Math.min(N, M) / 2; c++) {
				int x = c;
				int y = c;
				int temp = arr[x][y];

				int flag = 0;
				while (true) {
					// 범위체크
					int nx = x + dx[flag];
					int ny = y + dy[flag];
					if (nx < c || nx >= N-c || ny < c || ny >= M-c) {
						if (flag == 3) {
							break;
						} else {
							flag++;
							continue;
						}
					}
					// 회전 수행
					if (nx != c || ny != c) {
						arr[x][y] = arr[nx][ny];
					} else {
						arr[x][y] = temp;
						break;
					}
					x = nx;
					y = ny;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
