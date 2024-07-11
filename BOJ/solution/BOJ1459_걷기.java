package solution;

import java.util.*;
import java.io.*;

public class BOJ1459_걷기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        int normalTime = Integer.parseInt(st.nextToken());
        int crossTime = Integer.parseInt(st.nextToken());

        long ans;
        // 1*1 칸을 지나는 방법
        if(2*normalTime > crossTime) {
            long minSide = Math.min(x, y);
            long maxSide = Math.max(x, y);
            ans = minSide * crossTime;
            long rest = maxSide - minSide;    // 남은 일직선
            if(normalTime > crossTime) {
                if(rest % 2 == 0) {
                    ans += crossTime * rest;
                } else {
                    ans += crossTime * (rest - 1) + normalTime;
                }
            } else {
                ans += rest * normalTime;
            }
        } else {
            ans = (x+y) * normalTime;
        }

        System.out.println(ans);
    }
}
