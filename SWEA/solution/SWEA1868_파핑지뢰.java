package solution;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1868_파핑지뢰 {
    static class Node {
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int T, N, Ans;
    static char[][] map;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            Ans = 0;
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            // 지뢰아닌 곳들을 팔방에 지뢰 몇개인지 표시
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.')
                        map[i][j] = (char) (checkSide(i,j) +'0');
                }
            }

            //주변에 지뢰가 없는 애들 먼저 진행한다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '0') {
                        bfs(i,j);
                        Ans++;
                    }
                }
            }

            //아직 남은 지뢰가 있다면 더해준다(팔방이 막힌 애들)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] !='*' && map[i][j] != '#') Ans++;
                }
            }
            sb.append("#").append(tc).append(" ").append(Ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));

        while (!q.isEmpty()) {
            Node p = q.poll();
            int num = map[p.r][p.c];
            map[p.r][p.c] = '#';  //방문체크

            if(num != '0') continue;    //주변에 지뢰가 있다면 더이상 큐에 넣지 않는다
            //지뢰가 없다면(=0이면) 팔방에 있는 애들을 큐에 넣는다
            for (int d = 0; d < 8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>= N || nc <0 || nc>=N ) continue;

                if(map[nr][nc] != '#' && map[nr][nc] != '*') {  //내 기준 팔방 지역 증, 방문하지도 않았고, 지뢰도 아니면 큐에 넣는다
                    q.add(new Node(nr,nc));
                }
            }
        }
    }

    private static int checkSide(int r, int c) {
        int cnt=0;
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr<0 || nr>= N || nc <0 || nc>=N ) continue;
            //지뢰 찾으면 카운트
            if(map[nr][nc] == '*') cnt++;
        }
        return cnt;
    }
}
