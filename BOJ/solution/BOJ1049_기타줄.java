package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1049_기타줄 {
    static int N,M;
    static int[][] brand;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //필요한 기타 줄
        M = Integer.parseInt(st.nextToken());   // 브랜드 개수
        brand = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            brand[i][0] = Integer.parseInt(st.nextToken()); //패키지 가격
            brand[i][1] = Integer.parseInt(st.nextToken()); //낱개 가격
        }
        int a = N/6;
        int b = N%6;
        int pkg=Integer.MAX_VALUE, remainder=Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            pkg = Math.min(pkg, Math.min(brand[i][0], brand[i][1]*6));
            remainder = Math.min(remainder, Math.min(brand[i][0], brand[i][1]*b));
        }
        System.out.println(a*pkg + remainder);
    }
}
