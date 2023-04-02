//[BOJ]17070. 파이프옮기기1 - DFS
//파옮2는 무조건 dp로 풀어야 함 ㅎㅎ 나중에 ..
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070_파이프옮기기1 {
    static class Point {
        int r, c, dir;

        public Point(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int N, cnt=0;
    static int[][] map;
    static boolean[][] v;
    //                가 대 세
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[N][N];
        //dir - 0: 가로 1: 대각선 2: 세로
        backtracking(new Point(0, 1, 0));
        System.out.println(cnt);


    }

    private static void backtracking(Point p) {
        //dir이 0 -> 0,1 가능. 1-> 0,1,2 가능. 2->1,2 가능
        //내가 가리키고 있는 끝 방향을 기준점으로 둔다
        //basis part
        if (p.r == N - 1 && p.c == N - 1) {
            cnt++;
            return;
        }

        for (int d = 0; d < 3; d++) {
            //현재 파이프 방향이 가로-> 세로 불가 // 세로 -> 가로 불가
            if (p.dir == 0 && d == 2) continue;
            if (p.dir == 2 && d == 0) continue;

            int nr = p.r + dr[d];
            int nc = p.c + dc[d];

            //공통 처리: 영역 밖 + 다음 친구가 이미 방문처리 + 다음 친구가 1
            if (nr >= N || nc >= N || v[nr][nc] || map[nr][nc] == 1) continue;

            //대각선일 때에는 추가 2개를 더봐야한다. 영역 밖일 수 없으므로 체크할 필요 없음
            if(d==1 && (map[nr-1][nc] == 1 || map[nr][nc-1] == 1)) continue;
            v[nr][nc] = true;
            backtracking(new Point(nr, nc, d));
            v[nr][nc] = false;

        }

    }
}
