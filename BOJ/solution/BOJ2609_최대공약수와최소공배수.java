package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //최대공약수: 유클리드호제법
        int GCD = func(Math.max(a,b), Math.min(a,b));
        System.out.println(GCD);
        // 최소공배수
        int LCM = GCD * (a/GCD) * (b/GCD);
        System.out.println(LCM);
    }

    private static int func(int a, int b) {
        if(b == 0) return a;
        return func(b, a%b);
    }
}
