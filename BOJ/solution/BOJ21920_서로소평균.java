package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21920_서로소평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        System.out.println(solution(arr, X));
    }

    private static double solution(int[] arr, int x) {
        double answerSum = 0;
        double answerCnt = 0;
        for (int j : arr) {
            int min = Math.min(j, x);
            int max = Math.max(j, x);
            if (min == max) continue;
            int GCD = Euclidean(max, min);
            if (GCD == 1) {
                answerSum += j;
                answerCnt++;
            }
        }
        return answerSum / answerCnt;
    }

    private static int Euclidean(int a, int b) {
        if(a%b == 0) return b;
        return Euclidean(b,a%b);
    }
}
