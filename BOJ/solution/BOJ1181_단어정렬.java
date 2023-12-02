package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i < N; i++) {
            tmp.add(br.readLine());
        }
        List<String> arr = new ArrayList<>(tmp);
        arr.sort((o1, o2) -> {
            if(o1.length() != o2.length()) return o1.length() - o2.length();
            return o1.compareTo(o2);
                });

        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
