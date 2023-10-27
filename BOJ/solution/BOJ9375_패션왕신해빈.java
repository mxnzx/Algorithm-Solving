package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ9375_패션왕신해빈 {
    static int T, N;
    static Map<String, Integer> clothes;
    public static void main(String[] args) throws IOException {
        /*
        의상 이름, 의상 종류
        종류 중에 하나를 선택 하거나 / 안하거나
        부분집합
        공집합 제외
        종류를 인덱스로, 값을 하나씩 증가
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            clothes = new HashMap<>();
            N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();
                if(clothes.containsKey(key)) {
                    clothes.put(key,clothes.get(key)+1);
                } else {
                    clothes.put(key,1);
                }
            }
            System.out.println(clothes.size());
        }


    }
}
