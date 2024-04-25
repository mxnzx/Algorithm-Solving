package solution;

import java.io.*;
import java.util.*;

public class BOJ2096_내려가기 {

    static int n;
    static int[][] arr;
    static int[] maxSum, minSum;
    
    static void pick() {
        maxSum = new int[] {arr[0][0], arr[0][1], arr[0][2]};
        minSum = new int[] {arr[0][0], arr[0][1], arr[0][2]};

        for (int i = 1; i < n; i++) {
            int a = maxSum[0];
            int b = maxSum[1];
            int c = maxSum[2];
            maxSum[0] = arr[i][0] + Math.max(a, b);
            maxSum[1] = arr[i][1] + Math.max(Math.max(a, b), c);
            maxSum[2] = arr[i][2] + Math.max(b, c);

            a = minSum[0];
            b = minSum[1];
            c = minSum[2];
            minSum[0] = arr[i][0] + Math.min(a, b);
            minSum[1] = arr[i][1] + Math.min(Math.min(a, b), c);
            minSum[2] = arr[i][2] + Math.min(b, c);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pick();
        Arrays.sort(maxSum);
        Arrays.sort(minSum);
        System.out.println(maxSum[2]);
        System.out.println(minSum[0]);
    }
}
