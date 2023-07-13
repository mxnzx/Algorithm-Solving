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
        boolean isPackage = false;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            brand[i][0] = Integer.parseInt(st.nextToken()); //패키지 가격
            brand[i][1] = Integer.parseInt(st.nextToken()); //낱개 가격
            for (int cnt = 1; cnt <= 6; cnt++) {
                int tmpPrice = brand[i][1] * cnt;
                if(tmpPrice < brand[i][0]) continue;
//                if(cnt > N)
            }
        }
        //패키지가 유리한 지, 낱개가 유리한 지 먼저 체크 ?
    }
}
