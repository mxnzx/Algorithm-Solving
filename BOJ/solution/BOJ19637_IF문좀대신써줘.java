package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ19637_IF문좀대신써줘 {
    static int N, M;
    static Map<Integer, String> powerDict;
    static int[] powers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        powerDict = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (powerDict.containsKey(n)) continue;
            powerDict.put(n, name);
        }
        powers = new int[powerDict.size()];

        Set<Integer> keySet = powerDict.keySet();
        int n = 0;
        for(int key : keySet) {
            powers[n++] = key;
        }

        // 이분탐색
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());

            int idx = binarySearch(input);
            sb.append(powerDict.get(powers[idx])).append("\n");

        }
        System.out.println(sb);
    }

    public static int binarySearch(int input) {
        int searchIdx = Arrays.binarySearch(powers, input);
        if (searchIdx < 0) searchIdx = -(searchIdx + 1);
        return searchIdx;
    }
}
