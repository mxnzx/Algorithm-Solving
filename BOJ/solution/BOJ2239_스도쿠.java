package solution;

import java.io.*;

public class BOJ2239_스도쿠 {

    static int[][] map = new int[9][9];
    static boolean isDone = false;

    static boolean isValid(int r, int c, int val) {
        // r,c 검사
        for (int i = 0; i < 9; i++) {
            if(map[i][c] == val || map[r][i] == val) return false;
        }
        // 3*3 검사
        int sr = r / 3 * 3;
        int sc = c / 3 * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if(map[i][j] == val) return false;
            }
        }

        return true;
    }

    static void backtracking(int val) {

        if (val == 81) {
            isDone = true;
            return;
        }

        int r = val / 9;
        int c = val % 9;

        if (map[r][c] != 0) {
            backtracking(val + 1);
        } else {
            for (int k = 1; k < 10; k++) {
                // 나는 여기서 그냥 두고, 다음
                if(!isValid(r,c,k)) continue;
                map[r][c] = k;
                backtracking(val + 1);

                if (isDone) return;
                map[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        backtracking(0);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ans.append(map[i][j]);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
