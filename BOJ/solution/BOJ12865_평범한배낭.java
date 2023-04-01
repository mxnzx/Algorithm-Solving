package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865_평범한배낭 {
    static int N,K;
    static int[] W,V;
    static int[][] knapsack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        knapsack = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if(i == 0 || j == 0) {
                    knapsack[i][j]=0;
                    continue;
                }
                //넣을 수 없는 경우
                if(W[i] > j) knapsack[i][j] = knapsack[i-1][j];
                //넣을 수 있는 경우
                else knapsack[i][j] = Math.max(knapsack[i-1][j-W[i]] + V[i], knapsack[i-1][j]);

            }
        }
        System.out.println(knapsack[N][K]);
    }

}
