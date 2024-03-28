package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18809_Gaaaarden {

    static class Ground {
        int type;
        int updatedAt;

        Ground(int type, int updatedAt) {
            this.type = type;
            this.updatedAt = updatedAt;
        }

    }

    static class Loc {
        int r, c;
        int type;   //0:호수 1:뿌릴수없는땅 2:있는땅 3:초록배양액 4:빨강 5:꽃
        int cnt;

        Loc(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

        Loc(int r, int c, int type, int cnt) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.cnt = cnt;
        }
    }

    static int N, M, G, R, answer;
    static int[][] map;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<Loc> spreadGround = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) spreadGround.add(new Loc(i, j, map[i][j]));
            }
        }
        solution(spreadGround);
        System.out.println(answer);
    }

    private static void solution(List<Loc> spreadGround) {
        //1. type==2인 땅들 중에서 G+R개의 땅을 고른다(조합)
        pickGround(spreadGround, new Loc[G + R], 0, 0);
    }

    private static void pickGround(List<Loc> spreadGround, Loc[] pick, int idx, int p) {
        if (p == pick.length) {
            // 2. pick을 G와 R로 나눈다.
            divideGround(pick, new boolean[pick.length], 0, 0);
            return;
        }
        for (int i = idx; i < spreadGround.size(); i++) {
            pick[p] = spreadGround.get(i);
            pickGround(spreadGround, pick, i + 1, p + 1);
        }
    }

    private static void divideGround(Loc[] pick, boolean[] isGreen, int cnt, int idx) {

        if (cnt == G) {
            // 땅에 심고 시작하러 간다.
            startSpread(pick, isGreen);
            return;
        }
        if (idx == pick.length) return;

        isGreen[idx] = true;
        divideGround(pick, isGreen, cnt + 1, idx + 1);
        isGreen[idx] = false;
        divideGround(pick, isGreen, cnt, idx + 1);
    }

    private static void startSpread(Loc[] pick, boolean[] isGreen) {
        //지도 항상 새거로
        Ground[][] copyMap = new Ground[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = new Ground(map[i][j], 0);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < pick.length; i++) {
            Loc current = pick[i];
            if (isGreen[i]) {
                copyMap[current.r][current.c].type = 3;
            } else {
                copyMap[current.r][current.c].type = 4;
            }
            copyMap[current.r][current.c].updatedAt = -1;
            q.add(new Loc(current.r, current.c, copyMap[current.r][current.c].type, copyMap[current.r][current.c].updatedAt));
        }

        while (!q.isEmpty()) {
            Loc current = q.poll();
            if (copyMap[current.r][current.c].type == 5) continue;

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (copyMap[nr][nc].type == 1 || copyMap[nr][nc].type == 2) {
                    // 내가 갈수 있는 길이면 가서 내 영역 표시, 바뀐 updatedAt도 표시
                    // 맨 처음 뿌린 3,4는 만났다고 꽃이 되면 안됨. updateAt으로 관리하자
                    copyMap[nr][nc].type = current.type;
                    copyMap[nr][nc].updatedAt = current.cnt+1;
                    q.add(new Loc(nr, nc, copyMap[nr][nc].type, copyMap[nr][nc].updatedAt));
                    continue;
                }
                // updatedAt 체크해보고 같으면 5로 바꾼다. 여기서 처음뿌린 3,4는 updateAt=-1 이니 이건 제외
                if (((copyMap[current.r][current.c].type == 3 && copyMap[nr][nc].type == 4) ||
                        (copyMap[current.r][current.c].type == 4 && copyMap[nr][nc].type == 3)) &&
                        (copyMap[nr][nc].updatedAt == current.cnt + 1) && copyMap[nr][nc].updatedAt != -1) {
                    copyMap[nr][nc].type = 5;
                }
            }
        }
        answer = Math.max(countFlower(copyMap), answer);
    }

    private static int countFlower(Ground[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j].type == 5) cnt++;
            }
        }
        return cnt;
    }
}
