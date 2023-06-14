package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[2000002];   // x값의 범위에 맞춤
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        int x = Integer.parseInt(br.readLine());    //두 수의 합 = x

        int cnt = 0;
        for (int i = 0; i < x; i++) {
            // (x-현재값(i))값이 존재한다면 count++ -> 미친발상..
            if (arr[i] == 1 && arr[x - i] == 1) cnt++;
        }
        System.out.println(cnt / 2); //중복된 count 빼줌
    }
}
