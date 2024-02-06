package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16509_장군 {
    static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Node sang, king;
    static boolean[][] v = new boolean[10][9];
    //                       상 우 하 좌
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static final int[] ddr = {-1,-1,1,1};
    static final int[] ddc = {-1,1,1,-1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        sang = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        king = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(sang);
        v[sang.r][sang.c] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            //System.out.println(current);

            for (int d = 0; d < 4; d++) {
                // 상우하좌(시계방향) 한 칸 이동 (1)
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];

                if(!checkEdge(nr, nc)) continue;

                for (int dd = 0; dd < 2; dd++) {
                    int dir = (d + dd) % 4;
                    // 대각선으로 한 칸 이동 (2)
                    int nnr = nr + ddr[dir];
                    int nnc = nc + ddc[dir];

                    if(!checkEdge(nnr, nnc)) continue;
                    if(checkKing(nnr, nnc)) continue;

                    // 대각선으로 또 한 칸 이동(3)
                    nnr += ddr[dir];
                    nnc += ddc[dir];

                    if(!checkEdge(nnr, nnc) || v[nnr][nnc]) continue;
                    // 출력 조건
                    if(checkKing(nnr, nnc)) return current.cnt+1;

                    q.add(new Node(nnr, nnc, current.cnt+1));
                    v[nnr][nnc] = true;

                }
            }
        }

        return -1;

    }
    private static boolean checkEdge(int nr, int nc) {
        return nr >= 0 && nr < 10 && nc >= 0 && nc < 9;
    }
    private static boolean checkKing(int nr, int nc) {
        return nr == king.r && nc == king.c;
    }
}
