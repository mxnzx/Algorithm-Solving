package solution;

import java.io.*;
import java.util.*;

public class BOJ1269_대칭차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int sameCnt = A + B - set.size();
        System.out.println(set.size() - sameCnt);
    }
}
