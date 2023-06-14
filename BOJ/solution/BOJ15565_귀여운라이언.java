package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15565_귀여운라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N,K;
        ArrayList<Integer> lionIdxList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int num;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            if(num == 1) lionIdxList.add(i);
        }
        if(lionIdxList.size() < K) {
            System.out.println(-1);
            System.exit(0);
        }
        int arrSize, min = Integer.MAX_VALUE;
        for (int i = 0, j = K-1; j < lionIdxList.size(); i++, j++) {
            arrSize = lionIdxList.get(j) - lionIdxList.get(i) + 1;
            min = Math.min(arrSize, min);
        }
        System.out.println(min);
    }
}
