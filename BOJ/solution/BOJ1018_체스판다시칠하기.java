package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        //1. 첫 칸이 W인 경우
        int answer = 50 * 50;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(count(i, j, board, 'W'), answer);
                answer = Math.min(count(i, j, board, 'B'), answer);
            }
        }
        System.out.println(answer);

    }

    private static int count(int n, int m, char[][] board, char first) {
        int cnt = 0;
        char now = first;
        char beforeLineHead = first;
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (board[i][j] != now) cnt++;
                now = now == 'W' ? 'B' : 'W';
            }
            now = beforeLineHead == 'W' ? 'B' : 'W';
            beforeLineHead = now;
        }
        return cnt;
    }
}
