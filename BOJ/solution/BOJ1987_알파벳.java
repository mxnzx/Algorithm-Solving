/*
 * [BOJ]1987. 알파벳
 * DFS
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1987_알파벳 {
    private static class Point {
        int r,c,cnt,val;

        public Point(int r, int c, int cnt, int val) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.val = val;
        }
    }
    static int R,C, Ans=Integer.MIN_VALUE;
    static char[][] map;
    static boolean []v;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[26];  //마지막 알파벳 방문체크
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        //타고 갈 수 있는만큼 들어간다 -> dfs. 들어가서 최장값 계산
        //방문처리를 해주고 들어가는게 시간이 주나? -> 조금 더 감소하긴 함
        // 기본자료형 값을 보내고 dfs안에서 포인트 클래스를 만들어주는게 메모리효율이 10배 정도 차이남. (기존에 new Point()로 값을 보냄)
        v[map[0][0]-'A']=true;
        dfs(0,0,1);

        System.out.println(Ans);

    }
    private static void dfs(int r,int c, int cnt) {

        Point p = new Point(r,c,cnt,map[r][c]-'A');

        Ans = Math.max(Ans, p.cnt);
        System.out.println((char)(p.val+'A') + " " + p.cnt);

        for (int d = 0; d < 4; d++) {
            int nr = p.r + dr[d];
            int nc = p.c + dc[d];

            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;

            int nval = map[nr][nc] - 'A';
            if(!v[nval]) {
                v[nval] = true;

                dfs(nr,nc,cnt+1);
                v[nval] = false;
            }
        }
    }

}
