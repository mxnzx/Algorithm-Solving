package solution;

import java.io.*;

public class BOJ1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = 666;
        int cnt = 1;

        // 시간 복잡도: 약 100개마다 1개 카운트라고 가정, 100*10000 = 10^6
        while(cnt < n) {
            target++;
            int k = 0;
            int tmp = target;
            while(tmp != 0) {
                int a = tmp % 10;
                tmp /= 10;
                if(a == 6) {
                    k++;
                    continue;
                }
                if (k < 3) k = 0;
            }
            if(k >= 3) cnt++;
        }
        System.out.println(target);
    }
}
