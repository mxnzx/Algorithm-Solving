package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105_디저트카페 {

    static int T, N, res;
    static int[][] map;
    static boolean[] v;
    static int[] dr = {1,1,-1,-1};
    static int[] dc = {1,-1,-1,1};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            res = -1;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //전부다 비교해서 맥스값을 구해야 함 - 완탐
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    v = new boolean[101];   //1~100
                    dfs(i,j,i,j,0, 1);
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int r, int c, int startR, int startC, int dir, int cnt) {

        v[map[r][c]] = true;

        //무조건 오른쪽부터 둥글게 돈다 -> d=dir 이 회전시작값
        for (int d = dir; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            //가장자리
            if(nr<0 || nr>= N || nc<0 || nc>= N) continue;

            //다음 좌표가 시작좌표랑 같고, 마름모를 만들었다면(=cnt가 4이상)
            if(nr == startR && nc == startC && cnt >= 4) {
                res = Math.max(res, cnt);
                return;
            }
            //방문배열 체크: 이전에 도착여부 판단때문에 뒤로 뺌
            if(v[map[nr][nc]]) continue;

            dfs(nr,nc,startR,startC,d,cnt+1);
            v[map[nr][nc]]=false;
        }
    }

}