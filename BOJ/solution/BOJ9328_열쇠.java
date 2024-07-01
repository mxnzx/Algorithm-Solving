package solution;

import java.util.*;
import java.io.*;

public class BOJ9328_열쇠 {

    static class Loc {
        int r;
        int c;

        boolean[] myKeys;

        Loc(int r, int c, boolean[] keys) {
            this.r = r;
            this.c = c;
            this.myKeys = keys;
        }
    }

    static int N, M;
    static char[][] map;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static boolean[] initKeys = new boolean[26];

    static int startToSearch(int sr, int sc) {
        int docsCnt = 0;
        // [문제 핵심 1!] 길 탐색 중에 내가 못 열었던 문을 담아두고, 열쇠 찾으면 해당 지역을 큐에 담는다.
        List<Loc>[] closedDoors = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            closedDoors[i] = new ArrayList<>();
        }
        boolean[][] visited = new boolean[N + 2][M + 2];

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(sr, sc, initKeys));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Loc now = q.poll();
            char nowChar = map[now.r][now.c];
            // 큐에서 꺼낼 때 값들을 체크한다.
            // 문서 카운트
            if (nowChar == '$') docsCnt++;
            // 열쇠일 경우 줍는다
            if (isKey(nowChar)) {
                now.myKeys[nowChar - 'a'] = true;
                // 내가 못 열었던 방이 있다면 ->> 해당 문을 넣는다. 여러 개 가능.
                if (!closedDoors[nowChar - 'a'].isEmpty()) {
                    q.addAll(closedDoors[nowChar - 'a']);
                    closedDoors[nowChar - 'a'].clear();
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                // 큐에는 지나갈 수 있는 아이들만 넣는다.
                if (checkEdge(nr, nc) || map[nr][nc] == '*' || visited[nr][nc]) continue;
                if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z' && !now.myKeys[map[nr][nc] - 'A']) {
                    closedDoors[map[nr][nc] - 'A'].add(new Loc(nr, nc, now.myKeys));
                    continue;
                }
                q.add(new Loc(nr, nc, now.myKeys));
                visited[nr][nc] = true;
            }
        }

        return docsCnt;
    }

    static boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }

    static boolean checkEdge(int r, int c) {
        return r < 0 || r >= N + 2 || c < 0 || c >= M + 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // [문제 핵심 2!] map 가장자리에 null값의 길을 내어주고 시작한다. 돌아다닐 수 있는 길.
            map = new char[N + 2][M + 2];
            initKeys = new boolean[26];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i + 1][j + 1] = input.charAt(j);
                }
            }
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    initKeys[keys.charAt(i) - 'a'] = true;
                }
            }

            ans.append(startToSearch(0, 0)).append("\n");
        }
        System.out.println(ans);
    }
}
