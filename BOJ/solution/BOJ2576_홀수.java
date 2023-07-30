package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2576_홀수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> odd = new ArrayList<>();
        int sum=0;
        for (int i = 0; i < 7; i++) {
            int input =Integer.parseInt(br.readLine());
            if(input % 2 == 1)  {
                odd.add(input);
                sum+=input;
            }
        }
        solution(odd, sum);
    }

    private static void solution(List<Integer> odd, int sum) {
        if(odd.size() != 0) {
            Collections.sort(odd);
            System.out.println(sum);
            System.out.println(odd.get(0));
        } else {
            System.out.println(-1);
        }
    }

}
