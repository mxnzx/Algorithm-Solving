package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9613_GCD합 {
    static long sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            sum = 0;
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //GCD = 최대공약수
            Arrays.sort(arr);
            makePair(arr, new int[2], 0, 0);
            answer.append(sum).append("\n");
        }
        System.out.println(answer);
    }

    private static void makePair(int[] arr, int[] pick, int idx, int p) {

        if(p == pick.length) {
            //GCD 구하러감
            sum += getGCD(pick[0], pick[1]);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            pick[p] = arr[i];
            makePair(arr, pick, i+1, p+1);

        }
    }

    private static int getGCD(int a, int b) {
        //a가 항상 작음
        if(a == 0) return b;
        return getGCD(b % a, a);
    }
}
