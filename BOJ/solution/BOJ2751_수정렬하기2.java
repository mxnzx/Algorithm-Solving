package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> alist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            alist.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(alist);
        for(int i : alist) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
