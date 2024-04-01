package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13900_순서쌍의곱의합 {
    static int N;
    static long answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //조합
        // 서로 다른 위치 => 같은 수도 한 개씩 치겠다는 말.
        //곱의 합 -> 더해서 한번에 곱한다
        long prefixSum = 0;
        for (int i = 0; i < N; i++) {
            prefixSum += arr[i];
        }
        for (int i = 0; i < N - 1; i++) {
            prefixSum -= arr[i];
            answer += arr[i] * prefixSum;
        }
        System.out.println(answer);
    }
}
