//[BOJ]16234. 인구이동 - bfs
package solution;

import java.io.*;
import java.util.*;

public class BOJ16234_인구이동 {
    static class Loc {
        int r;
        int c;
        Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int N, L, R, dayCnt;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr= {-1,0,1,0};
    static final int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }

    private static void solution() {
        while(true) {
            visited = new boolean[N][N];
            boolean isMove = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;
                    //3. 인구 이동이 있었는지 확인하고 온다. 있었으면 true;
                    if(bfs(i,j)) isMove = true;
                }
            }
            if(!isMove) break;
            dayCnt++;
        }
        System.out.println(dayCnt);
    }

    private static boolean bfs(int r, int c) {
        // 인구 이동이 있었는지 체크.
        Queue<Loc> q = new LinkedList<>();
        Queue<Loc> union = new LinkedList<>();
        visited[r][c] = true;
        int sum = 0;
        q.add(new Loc(r,c));
        while(!q.isEmpty()) {
            Loc cur = q.poll();
            union.add(cur);
            sum += map[cur.r][cur.c];
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(nr<0 || nr >= N || nc<0 || nc>=N || visited[nr][nc]) continue;
                int sub = Math.abs(map[nr][nc] - map[cur.r][cur.c]);
                if(sub >= L && sub <= R) {
                    Loc next = new Loc(nr, nc);
                    q.add(next);
                    visited[nr][nc] = true;
                }
            }
        }
        if(union.size() < 2) return false;

        // 갱신될 인구 수 계산
        int newCnt = sum / union.size();
        while(!union.isEmpty()) {
            Loc loc = union.poll();
            map[loc.r][loc.c] = newCnt;
        }
        return true;
    }
}