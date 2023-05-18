package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2117_홈방범서비스 {
    static int[][] map;
    static boolean[][] v;
    static int T, N, M, res;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1스,1};
    static StringBuilder sb;
    static class Node {
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            res = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i,j);
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
    //마름모 모양을 만들면서 탐색한다
    private static void bfs(int r, int c) {
        v = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        v[r][c] = true;

        int serviceArea=0, size, homeCnt=0, profit;
        while (!q.isEmpty()) {
            size = q.size();
            serviceArea++;
            //사이즈별로
            for (int n = 0; n < size; n++) {
                Node p = q.poll();
                //큐에서 꺼냈는데 그 좌표가 1이면 카운팅
                if(map[p.r][p.c] == 1) homeCnt++;

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc]) continue;

                    q.add(new Node(nr,nc));
                    v[nr][nc] = true;
                }
            }
            //한 영역이 넣을 수 있는 노드를 큐에 넣고 나오면 다음 로직 실행한다
            //이익 = 서비스 제공받는 집(homeCnt)*M - 운영비용
            int serviceCost = (int) (Math.pow(serviceArea,2)+ Math.pow(serviceArea-1,2));
            profit = homeCnt*M - serviceCost;
            //System.out.println("homeCnt:"+homeCnt+" sc:" + serviceCost + " profit:"+profit);
            if(profit>=0) res = Math.max(homeCnt, res);
        }

    }
}
