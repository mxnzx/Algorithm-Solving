package solution;

import java.io.*;

public class BOJ3085_사탕게임 {
    static int n, max = 1;
    static char[][] map;

    // 사탕의 최대 개수를 계산하는 메소드
    static void countCandies() {
        for (int i = 0; i < n; i++) {
            int rowCnt = 1, colCnt = 1;
            for (int j = 1; j < n; j++) {
                // 행
                if (map[i][j] == map[i][j - 1]) rowCnt++;
                else {
                    max = Math.max(max, rowCnt);
                    rowCnt = 1;
                }
                // 열
                if (map[j][i] == map[j - 1][i]) colCnt++;
                else {
                    max = Math.max(max, colCnt);
                    colCnt = 1;
                }
            }
            // 마지막 연속 구간에 대한 처리
            max = Math.max(max, Math.max(rowCnt, colCnt));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // 초기 사탕 배열로 최대 개수 계산
        countCandies();

        // 사탕 위치를 바꿔가며 최대 개수를 갱신
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(map[i][j] != map[i][j+1]) tryRow(i,j);
                if(map[j][i] != map[j+1][i]) tryColumn(j, i);
            }
        }
        System.out.println(max);
    }

    private static void tryColumn(int r, int c) {
        swap(r, c, r + 1, c);
        countCandies();
        swap(r, c, r + 1, c);
    }

    private static void tryRow(int r, int c) {
        swap(r, c, r, c + 1);
        countCandies();
        swap(r, c, r, c + 1);
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }
}
