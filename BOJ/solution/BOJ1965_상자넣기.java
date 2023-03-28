package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1965_상자넣기 {
    static int n;
    static int[] arr, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        memo = new int[n];
        Arrays.fill(memo,1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max=1;
        for (int i = 1; i < n; i++) {
            //내(i) 앞으로 나보다 작은 수 중에서
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    //현재 나의 memo값과 현재 해당하는 j값에 +1 해준 수를 비교해서 더 큰 값을 갱신한다
                    memo[i] = Math.max(memo[j]+1, memo[i]);
                }
            }
            max = Math.max(memo[i],max);
        }
        System.out.println(max);

    }

}
