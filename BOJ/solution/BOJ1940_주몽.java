package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940_주몽 {
    static int N,M;
    static int[] item;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    //재료 수
        M = Integer.parseInt(br.readLine());    //필요한 재료 값
        item = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(item);
        int start=0, end=N-1, result=0, sum;
        while(start != end) {
            sum = item[start] + item[end];
            if(sum >= M) {
                if(sum == M) result++;
                end--;
            } else {
                start++;
            }
        }
        System.out.println(result);
    }
}
