package solution;

import java.io.*;

public class BOJ13022_늑대와올바른단어 {

    static boolean check(String input) {
        int idx = 0;
        while(idx < input.length()) {

            if(input.charAt(idx) != 'w') return false;

            if(idx + 4 > input.length()) return false;

            if(input.substring(idx, idx+4).equals("wolf")) {
                idx += 4;
            } else {
                int cnt = 0;
                for (int i = idx; i < input.length(); i++) {
                    if(input.charAt(i) != 'w') break;
                    cnt++;
                }
                String searchedWord = "w".repeat(cnt) + "o".repeat(cnt) + "l".repeat(cnt) + "f".repeat(cnt);
                int endIdx = idx + cnt * 4;
                if(endIdx <= input.length() && searchedWord.equals(input.substring(idx, endIdx))) {
                    idx = endIdx;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(check(input) ? 1 : 0);
    }
}