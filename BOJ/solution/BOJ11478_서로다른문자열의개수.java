package solution;

import java.util.*;
import java.io.*;

public class BOJ11478_서로다른문자열의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 1000개가 있을 때 서로 다 다르다면 ,, 경우의 수 : 1000+999+...+1 = 1000*1000 / 2 = 5*10^5
        Set<String> str = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                str.add(input.substring(i, j + 1));
            }
        }
        System.out.println(str.size());
    }
}
