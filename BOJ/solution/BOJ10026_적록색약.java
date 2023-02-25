/*
 * [BOJ]10026. 적록색약
 *  BFS
 *  막힌 부분 - 섬의 개수처럼 구간이 분리되어 나뉘는게 아니어서 메인부분에서의 처리를 하는데 헤맸다. -> 원래 하던대로 방문처리로 확인해주면 됨
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026_적록색약 {
    static private class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int cnt1 = 0, cnt2 = 0;
    static char[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //적록색약이 아닐때
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                //하나씩 돌면서 방문 안한곳으로 다시 들어감
                if (!v[r][c]) {
                    bfs(r, c);
                    //한 구간 탐색하고 나오면 카운트 업
                    cnt1++;
                }
            }
        }
        //방문배열 초기화
        v = new boolean[N][N];

        //적록색약일 때
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!v[r][c]) {
                    bfs2(r, c);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    //적록색약이 아닐때
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        v[r][c] = true;
        char nowColor = map[r][c];

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) continue;

                if (map[nr][nc] == nowColor) {
                    v[nr][nc] = true;
                    q.offer(new Point(nr, nc));
                }

            }
        }
    }
    private static void bfs2(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        v[r][c] = true;
        char nowColor = map[r][c];

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) continue;
                //파랑일땐 위와 동일
                if(nowColor == 'B') {
                    if (map[nr][nc] == nowColor) {
                        v[nr][nc] = true;
                        q.offer(new Point(nr, nc));
                    }
                } else {    //초록 또는 빨강일 땐 파랑만 아니면= 둘이 같은 색으로 침
                    if (map[nr][nc] != 'B') {
                        v[nr][nc] = true;
                        q.offer(new Point(nr, nc));
                    }
                }

            }
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
