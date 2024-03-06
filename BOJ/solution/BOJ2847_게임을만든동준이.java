package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2847_게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        // 내 다음 단계 점수보다 하나 작으면 된다.
        for (int i = N - 2; i >= 0; i--) {
            int target = arr[i + 1] - 1;
            if (arr[i] >= target) {
                cnt += arr[i] - target;
                arr[i] = target;
            }
        }
        System.out.println(cnt);
    }
}
