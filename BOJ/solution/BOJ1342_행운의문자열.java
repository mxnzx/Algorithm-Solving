package solution;

import java.io.*;
import java.util.*;

public class BOJ1342_행운의문자열 {

    static char[] alphabet;
    static int ans;

    static void solution(boolean[] visited, char[] pick, int p) {

        if(p == pick.length) {
            ans++;
            //System.out.println(Arrays.toString(pick));
            return;
        }

        char past = 'A';
        for (int i = 0; i < pick.length; i++) {
            if(visited[i]) continue;
            if(past == alphabet[i]) continue;
            pick[p] = alphabet[i];
            if(p > 0 && pick[p] == pick[p - 1]) continue;
            visited[i] = true;
            past = pick[p];
            solution(visited, pick, p + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        alphabet = br.readLine().toCharArray();
        Arrays.sort(alphabet);
        //인접한 모든 문자가 같지 않은 문자열 = 행운의 문자열
        solution(new boolean[alphabet.length], new char[alphabet.length], 0);

        System.out.println(ans);
    }
}
