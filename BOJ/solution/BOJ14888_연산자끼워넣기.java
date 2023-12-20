package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_연산자끼워넣기 {
    public static int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
    public static int n;
    public static int[] arr;
    public static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(arr[0], 1);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void backtracking(int result, int numIdx) {

        if (numIdx == n) {
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] <= 0) continue;
            operator[i]--;
            switch (i) {
                case 0:
                    backtracking(result+arr[numIdx], numIdx + 1);
                    break;
                case 1:
                    backtracking(result-arr[numIdx], numIdx + 1);
                    break;
                case 2:
                    backtracking(result*arr[numIdx], numIdx + 1);
                    break;
                case 3:
                    backtracking(result/arr[numIdx], numIdx + 1);
                    break;
            }
            operator[i]++;
        }
    }
}
