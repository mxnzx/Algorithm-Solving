package solution;

import java.util.*;
import java.io.*;

public class BOJ2740_행렬곱셈 {

    static int n, m, k;
    static int[][] matrix01, matrix02, matrixResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix01 = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix01[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        matrix02 = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                matrix02[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시간복잡도: 100*100*100
        matrixResult = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    matrixResult[i][j] += matrix01[i][l] * matrix02[l][j];
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                ans.append(matrixResult[i][j]).append(" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
