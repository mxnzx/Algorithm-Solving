package solution;

import java.io.*;
import java.util.*;

public class BOJ16926_배열돌리기1 {

    static int N, M, R;
    static int[][] map;
    static final int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    
    static void rotateMap(int cnt) {
        int prev = map[cnt][cnt];
        int tmp;
        int dir = 0;
        int r = cnt, c = cnt;

        while(true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr >= N-cnt || nr < cnt || nc >= M-cnt || nc < cnt) {
                if(dir == 3) break;
                dir++;
                continue;
            }

            tmp = map[nr][nc];
            map[nr][nc] = prev;
            prev = tmp;
            r = nr;
            c = nc;
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 반시계방향으로 R번
        // 가장자리를 만나면 방향 이동
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < Math.min(N, M) / 2; j++) {
                rotateMap(j);
            }
        }

        print();
    }
}
