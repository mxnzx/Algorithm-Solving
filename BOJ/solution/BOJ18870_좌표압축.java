package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870_좌표압축 {
    static int N;
    static int[] arr, sorted;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sorted = arr.clone();
        Arrays.sort(sorted);
        for (int i = 0, j=0; i < N; i++) {
            if(map.get(sorted[i]) != null) continue; //중복 값 제외
            map.put(sorted[i], j);
            j++;
        }
        for(int n : arr) {
            sb.append(map.get(n)).append(" ");
        }
        System.out.println(sb);
    }
}
