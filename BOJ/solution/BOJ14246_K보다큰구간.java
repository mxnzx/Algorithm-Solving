/*
 자료형 타입 지정에 신경쓰자!
 그리고 반복문 어떻게 하면 현명하게 한번만 돌릴수있는지에 대해 고민하기
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14246_K보다큰구간 {

    static int n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        long cnt = 0, sum = 0;
        int start =0, end=0;
        while(true) {
            if(sum > k) {
                cnt += n - end + 1;
                sum -= arr[start++];
            } else if (end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(cnt);
    }
}
