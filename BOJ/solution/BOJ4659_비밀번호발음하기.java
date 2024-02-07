package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659_비밀번호발음하기 {
    static final char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals("end")) {
            char[] inputArr = input.toCharArray();
            boolean isIncludeVowel = false;
            int consCnt = 0;    // 자음 개수
            int vowelCnt = 0;   // 모음 개수
            boolean isAcceptable = true;
            char prev = ' ';
            for (int i = 0; i < inputArr.length; i++) {
                char c = inputArr[i];
                boolean isVowel = false;
                // 요구사항 1
                for (char v : vowel) {
                    if (c == v) {
                        isIncludeVowel = true;
                        isVowel = true;
                        break;
                    }
                }
                // 요구사항 2
                if(isVowel) {
                    vowelCnt++;
                    consCnt = 0;
                } else {
                    consCnt++;
                    vowelCnt = 0;
                }
                if(vowelCnt == 3 || consCnt == 3) {
                    isAcceptable = false;
                    break;
                }
                // 요구사항 3
                if(c == 'e' || c == 'o') continue;
                if(c == prev) {
                    isAcceptable = false;
                    break;
                }
                prev = c;
            }
            if(!isIncludeVowel) isAcceptable = false;
            print(isAcceptable, input);

        }
        System.out.println(sb);

    }

    private static void print(boolean isAcceptable, String input) {
        sb.append("<").append(input).append("> is ");
        if(!isAcceptable) sb.append("not ");
        sb.append("acceptable.\n");
    }
}
