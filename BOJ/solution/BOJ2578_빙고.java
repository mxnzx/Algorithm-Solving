package solution;

import java.io.*;
import java.util.*;

public class BOJ2578_빙고 {
    static final int NUM = 5;
    static int[][] map;

    static void searchNum(int n) {
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                if(map[i][j] == n) {
                    map[i][j] = -1;
                    return;
                }
            }
        }
    }
    static boolean checkBingo() {
        int bingoLine = 0;
        boolean isBingo;

        for (int i = 0; i < NUM; i++) {
            isBingo = true;
            for (int j = 0; j < NUM; j++) {
                if(map[i][j] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if(isBingo) bingoLine++;
        }

        for (int i = 0; i < NUM; i++) {
            isBingo = true;
            for (int j = 0; j < NUM; j++) {
                if(map[j][i] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if(isBingo) bingoLine++;
        }

        isBingo = true;
        for (int i = 0; i < NUM; i++) {
            if(map[i][i] != -1) {
                isBingo = false;
                break;
            }
        }
        if(isBingo) bingoLine++;

        isBingo = true;
        for (int i = 0; i < NUM; i++) {
            if(map[i][NUM - 1 - i] != -1) {
                isBingo = false;
                break;
            }
        }
        if(isBingo) bingoLine++;

        return bingoLine >= 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[NUM][NUM];
        for (int i = 0; i < NUM; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int calledCnt = 0;
        for (int i = 0; i < NUM; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM; j++) {
                int calledNum = Integer.parseInt(st.nextToken());
                calledCnt++;
                searchNum(calledNum);
                if(checkBingo()) {
                    System.out.println(calledCnt);
                    return;
                }
            }
        }

    }
}
