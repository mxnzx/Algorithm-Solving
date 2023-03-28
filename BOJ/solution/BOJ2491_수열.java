package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2491_수열 {
    static int n;
    static int[] arr, dp1, dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp1 = new int[n];
        dp2 = new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max=1;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    //현재 나의 memo값과 현재 해당하는 j값에 +1 해준 수를 비교해서 더 큰 값을 갱신한다
                    dp1[i] = Math.max(dp1[j]+1, dp1[i]);
                }
            }
            max = Math.max(dp1[i],max);
        }
        System.out.println(max);

    }

}
