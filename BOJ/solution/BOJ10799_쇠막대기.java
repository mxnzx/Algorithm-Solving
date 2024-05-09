package solution;

import java.util.*;
import java.io.*;

public class BOJ10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> sticks = new Stack<>();
        int cnt = 0;
        char past = '(';
        for(char c: input) {
            if(c == '(') sticks.push(c);
            else {
                sticks.pop();
                if(past == ')') {
                    cnt++;
                } else {
                    cnt += sticks.size();
                }
            }
            past = c;
        }
        System.out.println(cnt);
    }
}
