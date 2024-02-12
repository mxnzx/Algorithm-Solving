package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16946_벽부수고이동하기4 {

    static int N, M, cnt;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static Map<Integer, Integer> area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        /*
        sol1) dfs 시초
        sol2) bfs 시초
        sol3) 0인 지역을 구분지어 마킹한다.
         */
        // 1. 넘버링 작업
        area = new HashMap<>();
        visited = new boolean[N][M];
        int number = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt = 0;
                    numberingArea(i, j, number);
                    area.put(number, cnt);
                    number++;
                }
            }
        }

        // 2. 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)  {
                    int cnt = count(i, j);
                    sb.append(cnt % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void numberingArea(int r, int c, int number) {

        visited[r][c] = true;
        map[r][c] = number;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 1) continue;

            numberingArea(nr, nc, number);
        }
    }

    public static int count(int r, int c) {

        int cnt = 1;
        Set<Integer> tmpArea = new HashSet<>();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] <= 1) continue;

            tmpArea.add(map[nr][nc]);
        }
        for(int n : tmpArea) {
            cnt += area.get(n);
        }

        return cnt;
    }
}
