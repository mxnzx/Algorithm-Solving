package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467_용액 {
    static int[] arr;
    static int N;
    static boolean plus, minus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 0) plus = true;
            if (arr[i] < 0) minus = true;
        }
        solution();
    }

    private static void solution() {
        if (!plus) {
            System.out.println(arr[N - 2] + " " + arr[N - 1]);
            return;
        }
        if (!minus) {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }
        //두 부호가 다 있을 때는 하나씩 비교해봐야 안다
        int s = 0, e = N-1;
        int sum, min = Integer.MAX_VALUE, minIdx1=-1, minIdx2=-1;
        while(s!=e) {
            sum = arr[s] + arr[e];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                if(min == 0) {
                    System.out.println(arr[s] + " "+ arr[e]);
                    System.exit(0);
                }
                minIdx1 = s;
                minIdx2 = e;
            }
            if(sum>0) e -= 1;
            if(sum<0) s += 1;
        }
        System.out.println(arr[minIdx1] + " " + arr[minIdx2]);
    }


}
