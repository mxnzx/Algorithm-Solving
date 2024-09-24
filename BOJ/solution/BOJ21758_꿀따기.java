package solution;

import java.util.*;
import java.io.*;

public class BOJ21758_꿀따기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max;
        int N = Integer.parseInt(br.readLine());
        int[] area = new int[N];
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            area[i] = Integer.parseInt(st.nextToken());
            total += area[i];
        }

        // 1. 양 끝 고정, 꿀통 이동 -> 사이 값중에 가장 큰 값을 두번 더해주면 된다.
        int middleMax = -1;
        for (int i = 1; i < N - 1; i++) {
            middleMax = Math.max(middleMax, area[i]);
        }
        max = total - area[0] - area[N - 1] + middleMax;

        // 2. 꿀통 맨 오른쪽, 왼쪽에서 오는 거
        int beeIdx1 = 0;
        int prev = area[1] * 2;
        int min = prev;
        for (int i = 2; i < N - 1; i++) {
            int now = prev - area[i-1] + area[i] * 2;
            prev = now;
            min = Math.min(min, now);
        }
        max = Math.max(max, total - area[beeIdx1] + total - area[beeIdx1] - min);

        // 3. 꿀통 맨 왼쪽, 오른쪽에서 오는 거
        beeIdx1 = N -1;
        prev = area[N - 2] * 2;
        min = prev;
        for (int i = N - 3; i > 0; i--) {
            int now = prev - area[i + 1] + area[i] * 2;
            prev = now;
            min = Math.min(min, now);
        }
        max = Math.max(max, total - area[beeIdx1] + total - area[beeIdx1] - min);
        System.out.println(max);
    }
}
