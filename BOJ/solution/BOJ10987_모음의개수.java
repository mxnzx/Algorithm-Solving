package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10987_모음의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int cnt = 0;
        for(char c : input) {
            for (char vowel : vowels) {
                if (c == vowel) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}
