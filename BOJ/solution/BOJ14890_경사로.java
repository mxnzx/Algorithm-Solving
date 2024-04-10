package solution;

import java.io.*;
import java.util.*;

public class BOJ14890_경사로 {
    static int N, L, cnt;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 브루트포스.
        // 접근 방법: 경사로를 둘 수 있는 곳을 구하고 표시.
        solution();
        System.out.println(cnt);

    }

    private static void solution() {
        // 행 먼저 우측 방향으로 탐색. 기준은 [i][j]이고 내 다음과 비교한다
        for (int i = 0; i < N; i++) {
            boolean isRoad = true;
            for (int j = 0; j < N - 1; j++) {

                if (map[i][j] == map[i][j + 1]) continue;

                boolean isRamp = true;
                if (map[i][j] == map[i][j + 1] + 1) {
                    // 경사로를 놓을 수 있는지 L만큼 확인한다. (L이 지도를 넘을 수 있음 주의)
                    if (j + L > N - 1) {
                        isRoad = false;
                        break;
                    }
                    for (int k = j + 1; k <= j + L; k++) {
                        if (map[i][j] != map[i][k] + 1) {
                            isRamp = false;
                            break;
                        }
                    }
                    if (isRamp) {
                        for (int k = j + 1; k <= j + L; k++) {
                            visited[i][k] = true;
                        }
                    } else {
                        isRoad = false;
                    }
                } else if (map[i][j] + 1 == map[i][j + 1]) {
                    // 뻭해서 경사로를 놓을 수 있는지 L만큼 확인한다. (L이 지도를 넘을 수 있음 주의)
                    if (j + 1 - L < 0) {
                        isRoad = false;
                        break;
                    }
                    for (int k = j; k >= j + 1 - L; k--) {
                        if (map[i][k] + 1 != map[i][j + 1]) {
                            isRamp = false;
                            isRoad = false;
                            break;
                        }
                        if (visited[i][k]) {
                            isRoad = false;
                            break;
                        }
                    }
                    if (isRamp) {
                        for (int k = j; k >= j + 1 - L; k--) {
                            visited[i][k] = true;
                        }
                    }
                } else {
                    isRoad = false;
                    break;
                }
            }
            if (isRoad) cnt++;

        }

        // 열 비교. 기준은 [i][j]이고 내 다음과 비교한다
        visited = new boolean[N][N];

        for (int j = 0; j < N; j++) {
            boolean isRoad = true;
            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] == map[i + 1][j]) {
                    continue;
                }
                boolean isRamp = true;
                if (map[i][j] == map[i + 1][j] + 1) {
                    // 경사로를 놓을 수 있는지 L만큼 확인한다. (L이 지도를 넘을 수 있음 주의)
                    if (i + L > N - 1) {
                        isRoad = false;
                        break;
                    }
                    for (int k = i + 1; k <= i + L; k++) {
                        if (map[i][j] != map[k][j] + 1) {
                            isRamp = false;
                            break;
                        }
                    }
                    if (isRamp) {
                        for (int k = i + 1; k <= i + L; k++) {
                            visited[k][j] = true;
                        }
                    } else {
                        isRoad = false;
                    }
                } else if (map[i][j] + 1 == map[i + 1][j]) {
                    // 뻭해서 경사로를 놓을 수 있는지 L만큼 확인한다. (L이 지도를 넘을 수 있음 주의)
                    if (i + 1 - L < 0) {
                        isRoad = false;
                        break;
                    }
                    for (int k = i; k >= i + 1 - L; k--) {
                        if (map[k][j] + 1 != map[i + 1][j]) {
                            isRamp = false;
                            isRoad = false;
                            break;
                        }
                        if (visited[k][j]) {
                            isRoad = false;
                            break;
                        }
                    }
                    if (isRamp && isRoad) {
                        for (int k = i; k >= i + 1 - L; k--) {
                            visited[k][j] = true;
                        }
                    }
                } else {
                    isRoad = false;
                    break;
                }
            }
            if (isRoad) cnt++;
        }
    }
}
