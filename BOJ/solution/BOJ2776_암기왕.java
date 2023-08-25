package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2776_암기왕 {
    static int N, M;
    // 해시 맵
//    static HashMap<Integer, Integer> dict;
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb= new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            N = Integer.parseInt(br.readLine());
//            dict = new HashMap<>();
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                dict.put(Integer.parseInt(st.nextToken()), 1);
//            }
//            M = Integer.parseInt(br.readLine());
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                int input = Integer.parseInt(st.nextToken());
//                boolean isTrue = dict.containsKey(input);
//                sb.append(isTrue ? 1 : 0).append("\n");
//            }
//        }
//        System.out.println(sb);
//    }
    // 이분탐색
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                int ans = Arrays.binarySearch(arr, input);
                System.out.println(ans);
                sb.append(ans >= 0 ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
