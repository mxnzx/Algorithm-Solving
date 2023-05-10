package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636_치즈 {
    //공기(0,0)을 시작점으로 bfs: 사방탐색하다가 1을 발견하면 체크해두고, bfs가 끝났으면 녹인다(후에 방문배열 새로)

    static class Node {
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[][] map;
    static boolean[][] v;
    static int R,C;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt=0;
        int beforeOneHourCnt=0;
        while (!isDone()) {
            beforeOneHourCnt = bfs();
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(beforeOneHourCnt);

    }
    //치즈가 다 녹았는지 확인
    private static boolean isDone() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static int bfs() {
        v = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        v[0][0] = true;

        while (!q.isEmpty()) {
            Node p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>=R || nc<0 || nc>=C || v[nr][nc]) continue;
                //다음 0을 넣는다
                if(map[nr][nc] == 0) q.add(new Node(nr,nc));
                //그 다음이 치즈건 아니건 일단 방문처리 해놓는다
                v[nr][nc] = true;
            }
        }
        //방문처리 되어있는 애들 중에 1인 애들만 녹여서 0으로 바꾼다
        //바꾼 개수 세서 두번째 출력값 대비
        int beforeOneHourCnt = meltingCheese(v);
        return beforeOneHourCnt;

    }
    //치즈 녹인다
    private static int meltingCheese(boolean[][] v) {
        int cnt=0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 1 && v[i][j]) {
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
