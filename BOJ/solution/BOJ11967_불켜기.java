package solution;

import java.util.*;
import java.io.*;

public class BOJ11967_불켜기 {

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static ArrayList<Node>[][] map;
    static boolean[][] isLight;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    static void turnOntheLight(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> tmp = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][N + 1];
        q.add(new Node(r, c));
        visited[r][c] = true;
        isLight[r][c] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            // 스위치를 켠다
            for (Node next : map[now.r][now.c]) {
                isLight[next.r][next.c] = true;
                if (!visited[next.r][next.c]) tmp.add(new Node(next.r, next.c));
            }

            // 주변으로 간다
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (nr <= 0 || nr > N || nc <= 0 || nc > N || visited[nr][nc]) continue;
                if (isLight[nr][nc]) {
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }

            // 새로 방 불을 킨 애들을 큐에 넣을 수 있는지 체크한다
            // 방 불을 킨 곳으로부터 현재 방문한 곳까지 올 수 있으면 이동 가능하다는 것
            // 방문하지 않았지만 방 불이 켜져있는 애들을 가지고 있다가, 그 방에 갈 수 있는지 확인해야 한다.

            while(!tmp.isEmpty()) {
                Node checkNode = tmp.poll();
                int i = checkNode.r;
                int j = checkNode.c;
                if(visited[i][j]) continue;
                // 인접한 곳에 방문했던 흔적이 있으면 큐에 넣는다
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr <= 0 || nr > N || nc <= 0 || nc > N) continue;
                    if (visited[nr][nc]) {
                        q.add(new Node(i, j));
                        visited[i][j] = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1][N + 1];
        isLight = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //내가 누구의 방 불을 켤수 있는지 알아야 함.
            map[x][y].add(new Node(a, b));
        }

        turnOntheLight(1, 1);

        int maxLightCnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isLight[i][j]) maxLightCnt++;
            }
        }
        System.out.println(maxLightCnt);
    }
}
