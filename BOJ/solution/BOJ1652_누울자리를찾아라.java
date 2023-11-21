package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1652_누울자리를찾아라 {
    static int N, width=0, height=0;
    static char[][] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            int widthCnt=0, heightCnt=0;
            for (int j = 0; j < N; j++) {
                // 가로
                if(room[i][j] == '.') widthCnt++;
                if(room[i][j] == 'X' || j == N-1) {
                    if(widthCnt >= 2) width++;
                    widthCnt=0;
                }
                // 세로
                if(room[j][i] == '.') heightCnt++;
                if(room[j][i] == 'X' || j == N-1) {
                    if(heightCnt >= 2) height++;
                    heightCnt=0;
                }
            }
        }
        System.out.println(width + " " + height);
    }
}

