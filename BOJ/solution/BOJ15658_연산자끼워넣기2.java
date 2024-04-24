package solution;

import java.util.*;
import java.io.*;

public class BOJ15658_연산자끼워넣기2 {

    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, op;

    static void backtracking(int cnt, int result) {

        if(cnt == arr.length) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(op[i] <= 0) continue;
            op[i]--;
            if(i == 0) backtracking(cnt + 1, result + arr[cnt]);
            if(i == 1) backtracking(cnt + 1, result - arr[cnt]);
            if(i == 2) backtracking(cnt + 1, result * arr[cnt]);
            if(i == 3) backtracking(cnt + 1, result / arr[cnt]);
            op[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
