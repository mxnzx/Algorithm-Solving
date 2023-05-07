package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427_불 {
    static class Node {
        int r,c, cnt;
        char val;

        public Node(int r, int c, char val, int cnt) {
            this.r = r;
            this.c = c;
            this.val = val;
            this.cnt = cnt;
        }
    }
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int T, W, H;
    static StringBuilder sb;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            v = new boolean[H][W];
            q = new LinkedList<>();
            //상근이 시작 위치
            int sgR=0, sgC=0;
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '@') {
                        sgR = i;
                        sgC = j;
                    }
                    //불이 들어오면 큐에 미리 넣어놓자 - 불부터 넣을거니까
                    if(map[i][j] == '*') {
                        q.add(new Node(i,j,'*',0));
                    }
                }
            }
            //불다넣었으니까 상근이 넣자
            q.add(new Node(sgR,sgC,'@',0));
            v[sgR][sgC] = true;

            int res = bfs();
            if(res == -1) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(res).append("\n");
            //System.out.println(res);
        }
        System.out.println(sb);

    }
    static int bfs() {

        while(!q.isEmpty()) {
            Node p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                //현재 불이라면,
                if(p.val == '*') {
                    if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc] == '#' || map[nr][nc] == '*') continue;
                    map[nr][nc] = '*';
                    q.add(new Node(nr,nc,'*',p.cnt));
                } else { //현재 상근이라면
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) return p.cnt + 1;
                    if (map[nr][nc] == '.' && !v[nr][nc]) {
                        v[nr][nc] = true;
                        q.add(new Node(nr, nc, '@', p.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
}
