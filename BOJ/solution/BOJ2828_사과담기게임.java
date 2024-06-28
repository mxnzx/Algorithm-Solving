package solution;

import java.util.*;
import java.io.*;

public class BOJ2828_사과담기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int appleCnt = Integer.parseInt(br.readLine());
        int rightEdgeBucketIdx = m;
        int ans = 0;
        for (int i = 0; i < appleCnt; i++) {
            int d = Integer.parseInt(br.readLine());
            if(d > rightEdgeBucketIdx - m && d <= rightEdgeBucketIdx) continue;

            if(d <= rightEdgeBucketIdx - m) {
                ans += rightEdgeBucketIdx - m + 1 - d;
                rightEdgeBucketIdx = m - 1 + d;
            } else {
                ans += d - rightEdgeBucketIdx;
                rightEdgeBucketIdx += d - rightEdgeBucketIdx;
            }
        }
        System.out.println(ans);

    }
}
