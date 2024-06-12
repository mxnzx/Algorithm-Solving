package solution;

import java.util.*;
import java.io.*;

public class BOJ1497_기타콘서트 {

    static int N, M, ans = Integer.MAX_VALUE, maxSongCnt;
    static boolean[] songs;
    static char[][] guitars;
    static boolean[] isPlayed;

    static void backtracking(int idx, boolean[] pick) {

        if(idx == N) {
            int tmpSongCnt = 0;
            for (int i = 0; i < M; i++) {
                if(isPlayed[i]) tmpSongCnt++;
            }

            if(maxSongCnt > tmpSongCnt) return;

            int usedGuitarCnt = 0;
            for (int i = 0; i < N; i++) {
                if(pick[i]) usedGuitarCnt++;
            }
            if(ans > usedGuitarCnt) {
                ans = usedGuitarCnt;
                maxSongCnt = tmpSongCnt;
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!isPlayed[j] && guitars[i][j] == 'Y') {
                    pick[i] = true;
                    isPlayed[j] = true;
                    guitars[i][j] = 'D';
                }
            }
            backtracking(i+1, pick);

            // j가 선택되었던 애들만 돌린다
            for (int j = 0; j < M; j++) {
                if(guitars[i][j] == 'D') {
                    guitars[i][j] = 'Y';
                    isPlayed[j] = false;
                }
            }
            pick[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitars = new char[N][M];
        songs = new boolean[M];
        isPlayed = new boolean[M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine().split(" ")[1];
            for (int j = 0; j < M; j++) {
                guitars[i][j] = input.charAt(j);
            }
        }
        backtracking(0, new boolean[N]);

        System.out.println(maxSongCnt == 0 ? -1 : ans);
    }
}
