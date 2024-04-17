package solution;

import java.util.*;
import java.io.*;

public class BOJ18110_solvedAC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        int cut = (int) Math.round(n * 0.15);
        int[] problem = new int[n];
        for (int i = 0; i < n; i++) {
            problem[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(problem);
        int sum = 0;
        for (int i = cut; i < n - cut; i++) sum += problem[i];

        System.out.println(Math.round(sum / (n - cut * 2.0)));
    }
}