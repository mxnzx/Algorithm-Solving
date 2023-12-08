package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1952_달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] isGone = new boolean[M][N];
        int dir = 0;
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int currentR = 0, currentC = 0;
        int changeCnt = 0;
        int wego = 1;
        isGone[currentR][currentC] = true;
        while (wego != M * N) {
            int nr = currentR + dr[dir];
            int nc = currentC + dc[dir];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && !isGone[nr][nc]) {
                isGone[nr][nc] = true;
                currentR = nr;
                currentC = nc;
                wego++;
            } else {
                dir = dir != 3 ? dir + 1 : 0;
                changeCnt++;
            }
        }
        System.out.println(changeCnt);
    }
}
