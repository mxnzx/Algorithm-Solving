package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4014_활주로건설 {
    static int T,N,X,cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());      //지도 크기
            X = Integer.parseInt(st.nextToken());      //활주로 길이
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //만약 다하고 나서 전체가 평지인 행열이 있다면 걔도 답으로 추가한다
            //인접한 두 칸의 차이가 매끄러우면(n+1 - n - n) 통과


        }
    }
}
