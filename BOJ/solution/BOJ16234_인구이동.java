//[BOJ]16234. 인구이동 - bfs
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234_인구이동 {
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N,L,R,cnt=0;
    static int[][] map;
    static boolean[][] v;
    static boolean doneUnion;    //인구이동이 안되는 플래그
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());   //최소
        R = Integer.parseInt(st.nextToken());   //최대

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            doneUnion = false;
            v = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //돌면서 방문안한 애들 그룹 묶어 인구이동 시킨다
                    if(!v[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            if(!doneUnion) {    //인구이동이 이루어지지 않았으면 탈출
                break;
            } else {    //인구이동이 이루어졌으면 카운팅하고 다시 반복
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static void bfs(int r, int c) {
        ArrayList<Point> union = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));

        v[r][c] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            union.add(new Point(p.r, p.c)); //큐에서 꺼낸 애들은 인구이동이 이루어지므로 union에 담아줌

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>= N || nc<0 || nc>=N ||v[nr][nc]) continue;
                int gap = Math.abs(map[p.r][p.c]-map[nr][nc]);
                if(gap >= L && gap <= R) {
                    q.add(new Point(nr,nc));
                    v[nr][nc] = true;
                }
            }
        }
        // 두 개 이상의 나라가 담겼으면 인구이동 시작한다
        if(union.size()>=2) {
            unionContury(union);
            doneUnion=true;
        }
    }
    private static void unionContury(ArrayList<Point> alist) {
        double sum=0;
        int n = alist.size();

        for(Point p:alist) {
            sum += map[p.r][p.c];
        }
        int res = (int) Math.floor(sum / n);

        for(Point p:alist) {
            map[p.r][p.c] = res;
        }
    }
}
