/*
 * [BOJ]4485. 녹색옷입은애가젤다지
 * 다익스트라
 * 놓친 부분: 처음 시작할때 가중치를 고려안함
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지 {
    static class Point {
        int r,c,weight;

        public Point(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
    static int N;
    static int[][] map, dist;
    static boolean[][] v;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 0;    //테케 번호

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N <= 0) break;
            tc++;

            map = new int[N][N];
            dist = new int[N][N];
            v = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //=============================입력

            //다익스트라
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dist[0][0] = map[0][0];

            PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing(Point::getWeight));
            q.add(new Point(0,0,dist[0][0]));

            while (!q.isEmpty()) {
                Point p = q.poll();
                int minR = p.r;
                int minC = p.c;
                int minDist = p.weight;
                v[p.r][p.c] = true;

                //도착했으면 값 출력
                if(minR == N-1 && minC == N-1) {
                    sb.append("Problem ").append(tc).append(": ").append(minDist).append("\n");
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = minR + dr[d];
                    int nc = minC + dc[d];
                    if(nr<0 || nr>=N || nc < 0 || nc>=N) continue;
                    int nw = map[nr][nc];

                    //다익스트라 조건 처리
                    if(!v[nr][nc] && dist[nr][nc] > minDist + nw) {
                        dist[nr][nc] = minDist + nw;
                        q.add(new Point(nr,nc,dist[nr][nc]));
                    }
                }
            }
        }
        System.out.println(sb);

    }
}
