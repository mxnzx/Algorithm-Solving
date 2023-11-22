package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> arr = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr.put(br.readLine(), 1);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(arr.containsKey(input)) cnt++;
        }
        System.out.println(cnt);
    }
}
