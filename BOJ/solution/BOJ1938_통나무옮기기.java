package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1938_통나무옮기기 {

    static class Node {
        int r, c, cnt;
        boolean type;   //true:가로   false:세로

        public Node(int r, int c, boolean type, int cnt) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.cnt = cnt;
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 최소 동작 횟수 -> BFS
    static int N, res;
    static int[][] map;
    static Node[] stick;
    static Node[] end;
    static boolean[][][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N][2];    //어떤 모양으로 들어왔는지 따지기 위해 3차원배열(가로0/세로1)
        stick = new Node[3];
        end = new Node[3];

        int tmp1 = 0, tmp2 = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 18) {
                    stick[tmp1++] = new Node(i, j);    //stick[0]을 가지고 움직인다
                }

                if (map[i][j] == 21) {
                    end[tmp2++] = new Node(i, j);    //end[0]과 대조한다
                }
            }
        }
        //들어온 stick과 end가 가로인지 세로인지 확인
        checkType(stick);
        checkType(end);
        //System.out.println(stick[0].type);
        //System.out.println(end[0].type);

        print(map);
        bfs();  //제일 처음 [0]만 가지고 bfs 실행한다
        System.out.println(res);

    }

    private static void checkType(Node[] arr) {
        boolean type = arr[0].r == arr[1].r;    //true:가로   false:세로
        for (int i = 0; i < arr.length; i++) {
            arr[i].type = type;
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(stick[0]);

        while (!q.isEmpty()) {
            Node p = q.poll();

            if(p.r == end[0].r && p.c == end[0].c && p.type == end[0].type) {
                res = p.cnt;
                return;
            }

            //상하좌우
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(p.type) {   //현재 방향이 가로
                    //가장자리 체크 - 행(r)은 하나만 봐도되고, 열(c)는 맨오른쪽도 봐야함 && 방문배열(가로)도 체크
                    if(nr<0 || nr>=N || nc<0 || (nc+2)>=N || v[nr][nc][0]) continue;
                    //가려는 곳 3칸이 전부 1이 없는 지 확인
                    if(map[nr][nc] == 1 || map[nr][nc+1] == 1 || map[nr][nc+2] == 1) continue;
                    q.add(new Node(nr,nc, true,p.cnt+1));

                    v[nr][nc][0] = true;
                } else {    //현재 방향이 세로
                    //가장자리 체크 - 열(c)은 하나만 봐도 되고, 행(r)은 맨오른쪽도 봐야함 && 방문배열 체크
                    if(nr<0 || (nr+2)>=N || nc<0 || nc>=N || v[nr][nc][1]) continue;
                    //가려는 곳 3칸 전부 1이 없는 지 확인
                    if(map[nr][nc] == 1 || map[nr+1][nc] == 1 || map[nr+2][nc] == 1) continue;
                    q.add(new Node(nr,nc, false,p.cnt+1));
                    v[nr][nc][1] = true;
                }
            }
            //회전
            if (check33(p.r, p.c, p.type)) {
                //회전한다
                q.add(new Node(p.r,p.c, !p.type,p.cnt+1));
                if(p.type) v[p.r][p.c][1] = true;    //가로면 세로
                else v[p.r][p.c][0] = true;          //세로면 가로
            }
        }
    }

    //3*3 갈수 있고, 다 비어있는지 체크
    private static boolean check33(int r, int c, boolean type) {
        System.out.println(r + " " + c + " " +type);
        if(type) {  //가로면 위에 3줄, 아래 3줄
            if(r-1<0 || r+1>=N) return false;
            for(int i = r-1; i <= r + 1; i++) {
                for (int j = c; j <= c + 2; j++) {
                    if (map[i][j] == 1) return false;
                }
            }
        } else {    //세로면 왼쪽 3줄, 오른쪽 3줄
            if(c-1<0 || c+1>=N) return false;
            for(int i = c-1; i <= c + 1; i++) {
                for (int j = r; j <= r + 2; j++) {
                    if (map[j][i] == 1) return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
