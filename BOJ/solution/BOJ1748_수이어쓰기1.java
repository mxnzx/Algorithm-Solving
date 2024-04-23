package solution;

import java.io.*;

public class BOJ1748_수이어쓰기1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 솔루션 1
//        String n = br.readLine();
//        int size = n.length();
//        long ans = 0;
//
//        for(int i=1; i<size; i++) {
//            ans += i * 9 * (long) Math.pow(10, i - 1);
//        }
//
//        int s = (int)Math.pow(10, size - 1);
//        int e = Integer.parseInt(n);
//        ans += (long) size * (e - s + 1);
//        System.out.println(ans);
        // 솔루션 2
        int n = Integer.parseInt(br.readLine());
        int num = 10;
        int plus = 1;
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(i % num == 0) {
                //자릿수 바뀌는 구간
                plus++;
                num *= 10;
            }
            cnt += plus;
        }
        System.out.println(cnt);
    }
}
