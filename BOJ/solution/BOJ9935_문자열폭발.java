package solution;

import java.io.*;
import java.util.Stack;

public class BOJ9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= len) {
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    if(stack.get(stack.size() - len + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for (int j = 0; j < len; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(Character c : stack) {
            ans.append(c);
        }
        System.out.println(ans.length() == 0 ? "FRULA" : ans);
    }
}
