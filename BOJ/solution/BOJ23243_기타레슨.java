package solution;

import java.io.*;
import java.util.*;

public class BOJ23243_기타레슨 {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        int lo = 0;
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            lo = Math.max(arr[i], lo);
        }

        System.out.println(binarySearch(lo, total));
    }

    private static int binarySearch(int lo, int hi) {

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            // 가능하면 왼쪽으로 좁히고, 불가능하면 오른쪽으로 좁힌다
            int sum = 0;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if(sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) cnt++;
            if(cnt > M) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
