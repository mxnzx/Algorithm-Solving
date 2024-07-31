package solution;

import java.io.*;
import java.util.*;

public class BOJ1834_나머지와몫이같은수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = 0L;
        for (int i = 1; i < N; i++) {  // 몫
            ans += (long) N * i + i;
        }
        System.out.println(ans);

    }
}
