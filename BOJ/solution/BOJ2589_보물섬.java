package solution;
/*
 * [BOJ]2589. 보물섬
 * bfs
 * 실수부분: 반복문 횟수 확인 못함 / bfs는 카운트 셀 때 무조건 자기값을 가지고 있어야 함. 최단거리이기 땜에. 실수 두번째임 조심하기 -_-
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589_보물섬 {
    static int R,C,max=Integer.MIN_VALUE;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] v;
    static class Node {
        int r,c,cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static ArrayList<Node> land = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'L') land.add(new Node(i,j,0));
            }
        }

        //L을 하나씩 돌면서 가장 멀리 갈 수 있는 거리를 리턴하고 맥스값 비교
        for (Node node : land) {
            int cnt = bfs(node);
            //최대값 갱신
            if (max < cnt) {
                max = cnt;
            }
        }
        System.out.println(max);

    }

    private static int bfs(Node node) {
        v = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        v[node.r][node.c] = true;
        int cnt=0;

        while(!q.isEmpty()) {
            Node p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                cnt=p.cnt;

                if(nr<0 || nr>=R || nc<0 || nc>=C || v[nr][nc] || map[nr][nc] == 'W') continue;

                v[nr][nc]=true;
                q.add(new Node(nr,nc,p.cnt+1));

            }
        }
        //마지막껀 안더해져서 +1해준다
        return cnt;
    }
}
