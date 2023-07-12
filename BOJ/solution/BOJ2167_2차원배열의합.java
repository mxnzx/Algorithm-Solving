package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2167_2차원배열의합 {
    static int N,M,K;
    static int[][] map, sumMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        sumMap = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] + map[i][j] - sumMap[i-1][j-1];
            }
        }
        K = Integer.parseInt(br.readLine());
        int i,j,x,y,result;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            result = sumMap[x][y] - sumMap[x][j-1] - sumMap[i-1][y] + sumMap[i-1][j-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}