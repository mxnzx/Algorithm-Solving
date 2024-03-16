package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJf3190_뱀 {
    static class Loc {
        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, K, L;
    static int[][] map;
    static final int[] dr = {0, 1, 0, -1}; //우 하 좌 상
    static final int[] dc = {1, 0, -1, 0};
    static char[] direction = new char[10000 + 1];
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;    //사과 -1
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);    // 왼쪽(L), 오른쪽(D)
            direction[X] = C;
        }
        map[1][1] = 1;
        start(1, 1, 0);
    }

    private static void start(int r, int c, int dir) {
        Deque<Loc> snake = new LinkedList<>();
        snake.add(new Loc(r, c));
        while (true) {
            // 시간이 1초 지나고, 이동
            time++;
            // 내 앞이 뭔지 확인 - 벽이나 내 몸이면 죽어
            int nr = snake.peekFirst().r + dr[dir];
            int nc = snake.peekFirst().c + dc[dir];
            if (nr <= 0 || nr > N || nc <= 0 || nc > N || map[nr][nc] == 1) break;
            // 사과 있는지 확인 - 있으면 몸늘리고, 없으면 이동
            if (map[nr][nc] == -1) {
                map[nr][nc] = 1;
            } else {
                map[snake.peekLast().r][snake.peekLast().c] = 0;
                snake.pollLast();
            }
            snake.addFirst(new Loc(nr, nc));
            map[nr][nc] = 1;
            // 방향 변경하려면 바꿈
            if (time > 10000) continue;
            if (direction[time] == 'D') {
                dir = (dir + 1) % 4;
            } else if (direction[time] == 'L') {
                dir = (dir == 0) ? 3 : dir - 1;
            }

        }
        System.out.println(time);
    }
}
