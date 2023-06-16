package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003_피보나치함수 {
    static int[][] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibo = new int[N+1][2];
            //바텀 업
            fibo[0][0] = 1;
            if(N>0) fibo[1][1] = 1;
            for (int j = 2; j <= N; j++) {
                fibo[j][0] = fibo[j-1][0] + fibo[j-2][0];
                fibo[j][1] = fibo[j-1][1] + fibo[j-2][1];
            }
            sb.append(fibo[N][0]).append(" ").append(fibo[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
