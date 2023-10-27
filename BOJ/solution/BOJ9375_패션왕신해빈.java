/*
Map에 values()라는 메서드 존재한다!
이는 해당 맵을 순환하면서 값을 하나씩 꺼내줄 수 있다.
신기하군,,, 처음알았다
 */

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
                if (clothes.containsKey(key)) {
                    clothes.put(key, clothes.get(key) + 1);
                } else {
                    clothes.put(key, 1);
                }
            }

            int ans = 1;
            for (int value : clothes.values()) {
                ans *= value + 1;
            }
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
    }
}
