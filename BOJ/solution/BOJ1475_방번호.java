package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();
        // 6,9만 교차가 가능하다: 하나로 본다
        System.out.println(solution(n));

    }
    static int solution(char[] input) {
        int[] num = new int[9];
        for(char c : input) {
            int n = c - '0';
            if(n == 9) n = 6;
            num[n]++;
        }
        num[6] = (num[6] % 2 == 0) ? num[6] / 2 : num[6] / 2 + 1;
        Arrays.sort(num);
        return num[num.length - 1];
    }
}
