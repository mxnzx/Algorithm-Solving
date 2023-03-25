/*
 * [BOJ]2573. 빙산 - bfs
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573_빙산 {
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N,M,cnt;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] v;
    static boolean divide=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //빙산을 찾고 bfs를 하면서 빙산을 만나면(=0보다 큰 애들을 만나면) 걔네의 값에서 -1을 한다.
        //빙산 분리 되었는지 확인 -> 처음잡은 빙산이 한번에 탐색이 안되면 빙산이 두개로 나뉜것이다

        L:while(true) {
            cnt++;
            boolean checkDiv = false;
            v=new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    //빙산이고 아직 방문하지 않은 빙산이 있다면 여길 탄다. -> 이걸 두번타면 빙산이 둘로 나뉜것
                    if(map[i][j] > 0 && !v[i][j]) {
                        //빙산이 한 덩어리가 아닐 경우
                        if(checkDiv) {
                            divide = true;
                            break L;
                        }
                        bfs(i,j);
                        checkDiv=true;  //한번 체크하고 오면 true. 빙산이 나뉘었는지 체크해주는 flag
                    }
                }
            }
            //빙산이 다 녹았을 경우(= 빙산이 없어서 위의 조건문을 타지 못하는 경우)
            if(!checkDiv) break;
        }
        if(divide) System.out.println(cnt-1);
        else {
            System.out.println(0);
        }
    }
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        v[r][c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                //이미 방문한 빙산은 바로 패스 (빙산이 녹는데에 영향 안끼침)
                if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]) continue;
                //0보다 작으면 바다이므로 현재 빙산을 녹인다
                if(map[nr][nc] <= 0) map[p.r][p.c]--;
                else {  //위에서 바다가 걸리므로 방문하지 않은 빙산만 여길 탐.
                    q.add(new Point(nr,nc));
                    v[nr][nc] = true;
                }
            }
        }

    }

}
