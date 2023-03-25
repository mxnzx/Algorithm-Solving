package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399_ATM {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //제일 빨리 뽑는 사람을 먼저 세운다
        Arrays.sort(arr);
        int sum=arr[0];
        for (int i = 0; i < N-1; i++) {
            arr[i+1] += arr[i];
            sum+=arr[i+1];
        }
        System.out.println(sum);

    }
}
