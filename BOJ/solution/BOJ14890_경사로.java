package solution;

import java.io.*;
import java.util.*;

public class BOJ14890_경사로 {
    static int N, L, cnt;
    static int[][] map, reverseMap;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        reverseMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                reverseMap[j][i] = n;
            }
        }
        // 브루트포스.
        // 접근 방법: 경사로를 둘 수 있는 곳을 구하고 표시.
        for (int i = 0; i < N; i++) {
            solution(map[i]);
            solution(reverseMap[i]);
        }
        System.out.println(cnt);
    }

    private static void solution(int[] map) {
        visited = new boolean[N];
        // 기준은 [i][j]이고 내 다음과 비교한다
        boolean isRoad = true;
        L:
        for (int i = 0; i < N - 1; i++) {

            if (map[i] == map[i + 1]) continue;

            if (map[i] == map[i + 1] + 1) {
                // 경사로를 놓을 수 있는지 L만큼 확인한다. (L이 지도를 넘을 수 있음 주의)
                if (i + L > N - 1) {
                    isRoad = false;
                    break;
                }
                for (int j = i + 1; j <= i + L; j++) {
                    if (map[i] != map[j] + 1) {
                        isRoad = false;
                        break L;
                    }
                }
                for (int j = i + 1; j <= i + L; j++) {
                    visited[j] = true;
                }
            } else if (map[i] + 1 == map[i + 1]) {
                // 빽해서 경사로를 놓을 수 있는지 L만큼 확인한다. (L이 지도를 넘을 수 있음 주의)
                if (i + 1 - L < 0) {
                    isRoad = false;
                    break;
                }
                for (int j = i; j >= i + 1 - L; j--) {
                    if (map[j] + 1 != map[i + 1] || visited[j]) {
                        isRoad = false;
                        break L;
                    }
                }
                for (int j = i; j >= i + 1 - L; j--) {
                    visited[j] = true;
                }
            } else {
                isRoad = false;
                break;
            }
        }
        if (isRoad) cnt++;
    }
}
