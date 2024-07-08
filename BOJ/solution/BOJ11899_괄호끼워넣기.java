package solution;

import java.util.*;
import java.io.*;

public class BOJ11899_괄호끼워넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int cnt = 0;
        Stack<Character> s = new Stack<>();
        for(char c : input) {
            if(c == '(') s.push(c);
            else {
                if(s.empty()) cnt++;
                else s.pop();
            }
        }
        cnt += s.size();
        System.out.println(cnt);

    }
}
