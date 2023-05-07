package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593_상범빌딩 {

    static class Node {
        int r,c,l,cnt;

        public Node(int r, int c, int l, int cnt) {
            this.r = r;
            this.c = c;
            this.l = l;
            this.cnt = cnt;
        }
    }
    static char[][][] map;
    static boolean[][][] v;
    static int L,R,C;
    //                 상 하 북 남 서 동
    static int[] dl = {-1,1,0,0,0,0};
    static int[] dr = {0,0,-1,1,0,0};
    static int[] dc = {0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("0 0 0")) break;
            st = new StringTokenizer(str);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            int startR=0, startC=0, startL=0;
            map = new char[R][C][L];
            v = new boolean[R][C][L];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[j][k][i] = str.charAt(k);   // map[행][열][층]
                        if(map[j][k][i] == 'S') {
                            startR = j;
                            startC = k;
                            startL = i;
                        }
                    }
                }
                str = br.readLine();    //밑줄 읽는다
            }

            int res = bfs(new Node(startR,startC,startL,0));
            if(res != -1) sb.append("Escaped in ").append(res).append(" minute(s).\n");
            else sb.append("Trapped!\n");
        }
        System.out.println(sb);
    }
    private static int bfs(Node start) {

        Queue<Node> q = new LinkedList<>();
        q.add(start);
        v[start.r][start.c][start.l] = true;

        while (!q.isEmpty()) {
            Node p = q.poll();

            for (int d = 0; d < 6; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int nl = p.l + dl[d];

                if(nr<0 || nr>= R || nc<0 || nc>=C || nl<0 || nl>=L || v[nr][nc][nl] || map[nr][nc][nl] =='#') continue;
                //E가 나오면 리턴
                if(map[nr][nc][nl] =='E') return p.cnt+1;

                q.add(new Node(nr,nc,nl,p.cnt+1));
                v[nr][nc][nl] = true;

            }
        }
        return -1;
    }
}
