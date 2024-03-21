package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685_드래곤커브 {

    static class Loc {
        int y, x;

        Loc(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int K;
    static boolean[][] map = new boolean[101][101];
    static final int[] dy = {0, -1, 0, 1}; //우 상 좌 하
    static final int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //열
            int y = Integer.parseInt(st.nextToken()); //행
            int d = Integer.parseInt(st.nextToken()); //시작방향
            int g = Integer.parseInt(st.nextToken()); //세대
            makeDragonCurb(x, y, d, g);
        }
        countDragonCurb();

    }

    private static void countDragonCurb() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void makeDragonCurb(int x, int y, int d, int g) {
        // 행열 주의!~!
        map[y][x] = true;
        map[y + dy[d]][x + dx[d]] = true;
        List<Loc> dcLine = new ArrayList<>();
        dcLine.add(new Loc(y, x));
        dcLine.add(new Loc(y + dy[d], x + dx[d]));
        Loc current = dcLine.get(dcLine.size()-1);
        //g만큼 반복
        for (int i = 0; i < g; i++) {
            // 과거를 따라가며 현재를 그린다
            // 현재 따라가고 있는 점을 계속 가지고 있으면서
            int size = dcLine.size();
            for (int j = size - 1; j > 0; j--) {
                int currentDir = findForwardDir(dcLine,j);
                map[current.y + dy[currentDir]][current.x + dx[currentDir]] = true;
                dcLine.add(new Loc(current.y + dy[currentDir], current.x + dx[currentDir]));
                current = dcLine.get(dcLine.size()-1);
            }
        }
    }

    private static int findForwardDir(List<Loc> dcLine, int j) {
        Loc current = dcLine.get(j);
        Loc forward = dcLine.get(j-1);

        if(forward.y - current.y == -1) return 0;
        if(forward.x - current.x == -1) return 1;
        if (forward.y - current.y == 1) return 2;
        if(forward.x - current.x == 1) return 3;
        return -1;
    }
}
