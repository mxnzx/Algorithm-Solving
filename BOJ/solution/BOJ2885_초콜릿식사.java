package solution;

import java.io.*;

public class BOJ2885_초콜릿식사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int size = 1;
        // 2의 제곱으로 필요한 초콜릿의 크기를 구한다
        while(size < k) size *= 2;
        // 몇 번 쪼개야 하는지 구한다.
        int cnt = 0;
        int chocoSize = size;
        while(k > 0) {
            // 초코사이즈가 k보다 크면 반을 쪼갠다
            if(chocoSize > k) {
                chocoSize /= 2;
                cnt++;
            } else {
                k -= chocoSize;
            }
        }
        System.out.println(size + " " + cnt);
    }
}
