package solution;

import java.io.*;

public class BOJ1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 단어 몇 번 등장해? 대신 중복되지 않게
        String searchWord = br.readLine();
        int len = searchWord.length();
        int cnt = 0;
        for (int i = 0; i <= input.length() - searchWord.length();) {
            if(input.substring(i, i+ len).equals(searchWord)) {
                cnt++;
                i += len;
            } else {
                i++;
            }
        }
        System.out.println(cnt);
    }
}
