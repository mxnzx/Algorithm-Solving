/*
 * [BOJ]7576. 토마토
 * BFS
 * 막힌 부분: 딱히 없는데 생각해내는 데 그냥 오래걸림 -> 기본 문법지식의 부족 문제인듯
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_토마토 {
    static int M, N;
    static int[][] tmtInfo;
    static boolean[][] v;
    static int day = 0; //익는데 걸리는 날짜(= 트리 레벨)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   //가로(열)
        N = Integer.parseInt(st.nextToken());   //세로(행)

        tmtInfo = new int[N][M];
        v = new boolean[N][M];  //방문 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tmtInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        //bfs 를 다 돌고도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //못 익은 게 있다면
                if(tmtInfo[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(day);
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    static class Point {
        int r,c,day;

        public Point(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();

        //익은 토마토(1) 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tmtInfo[i][j] == 1 && !v[i][j]) {
                    q.offer(new Point(i,j,0));
                    v[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                //가장자리 조건, 방문안한곳, 0인곳
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && tmtInfo[nr][nc] == 0) {
                    q.offer(new Point(nr, nc, p.day + 1));
                    v[nr][nc] = true;
                    tmtInfo[nr][nc] = 1;
                }
            }
            //만약 1,-1로만 이루어진 배열이 들어오면 bfs의 조건문을 거치지 않아 day가 증가하지 않고 bfs가 끝난다
            day = p.day;
        }
    }
}
