package solution;

import java.io.*;

public class BOJ1331_나이트투어 {

    static boolean[][] map = new boolean[6][6];
    static int fr = -1, fc = -1;
    static int[] dr = {-1,-2,-2,-1,1,2,2,1};
    static int[] dc = {-2,-1,1,2,2,1,-1,-2};

    static boolean tryNightTour(int cr, int cc, int pr, int pc) {

        for (int d = 0; d < 8; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if(nr < 0 || nr >= 6 || nc < 0 || nc >= 6 || !map[nr][nc]) continue;
            if(pr == nr && pc == nc) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pr = -1, pc = -1;
        for (int i = 0; i < 36; i++) {
            String input = br.readLine();
            int c = input.charAt(0) - 'A';
            int r = input.charAt(1) - '0' - 1;
            if(i > 0) {
                if(map[r][c] || !tryNightTour(r, c, pr, pc)) {
                    System.out.println("Invalid");
                    return;
                } else {
                    map[r][c] = true;
                    pr = r;
                    pc = c;
                }
            }
            if(i == 0) {
                fr = r;
                fc = c;
                map[r][c] = true;
                pr = r;
                pc = c;
            }
            if(i == 35) {
                if(tryNightTour(r, c, fr, fc)) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
        }
    }
}
