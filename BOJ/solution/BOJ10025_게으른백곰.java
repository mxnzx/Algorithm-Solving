// 슬라이딩 윈도우: 윈도우 크기에 주의하자

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10025_게으른백곰 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //크기가 고정적 : K
        //배열안의 연속적인 수의 합을 구함
        // 슬라이딩 윈도우
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[1000001];
        int gram, pos;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gram = Integer.parseInt(st.nextToken());
            pos = Integer.parseInt(st.nextToken());
            arr[pos] = gram;

        }
        int size = 2*K+1;
        int sum=0;
        for (int i = 0; i < ((size<=arr.length)? size : arr.length); i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = size; i < arr.length; i++) {
            sum = sum - arr[i-size] + arr[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
