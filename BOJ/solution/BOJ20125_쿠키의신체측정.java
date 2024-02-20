package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20125_쿠키의신체측정 {
    static class Loc {
        int r, c;

        public Loc() {
        }

        Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Loc head, heart, startWaist, leftLeg, rightLeg;

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N + 1][N + 1];
        boolean ishead = false;

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = input.charAt(j-1);
                if (map[i][j] == '*' && !ishead) {
                    ishead = true;
                    head = new Loc(i, j);
                    heart = new Loc(i + 1, j);
                    startWaist = new Loc(i + 2, j);
                    leftLeg = new Loc();
                    rightLeg = new Loc();
                    leftLeg.c = j-1;
                    rightLeg.c = j + 1;
                }
            }
        }
        int leftArmLength = searchLeftArm();
        int rightArmLength = searchRightArm();
        int waistLength = searchRow(startWaist);
        leftLeg.r = startWaist.r + waistLength;
        rightLeg.r = startWaist.r + waistLength;
        int leftLegLength = searchRow(leftLeg);
        int rightLegLength = searchRow(rightLeg);

        System.out.println(heart.r +" " + heart.c);
        System.out.println(leftArmLength + " " + rightArmLength + " " + waistLength + " " + leftLegLength + " " + rightLegLength);
    }

    private static int searchRow(Loc loc) {
        for (int i = loc.r; i <= N; i++) {
            if(map[i][loc.c] == '_') return i - loc.r;
            if(i == N) return i - loc.r + 1;
        }
        return -1;
    }

    public static int searchLeftArm() {
        for (int i = 1; i < N; i++) {
            if (map[heart.r][i] == '*') return heart.c - i;
        }
        return -1;
    }

    public static int searchRightArm() {
        for (int i = heart.c; i <= N; i++) {
            if (map[heart.r][i] == '_') return i - 1 - heart.c;
            if (i == N) return i - heart.c;
        }
        return -1;
    }
}
