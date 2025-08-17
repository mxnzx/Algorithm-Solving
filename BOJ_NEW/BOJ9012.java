package BOJ_NEW;

import java.util.*;
import java.io.*;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for(int i=1; i<=N; i++){
            String str = br.readLine();

            for (int j=0; j<str.length(); j++){
                char ch = str.charAt(j);
                if(ch=='(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) {
                        stack.push(ch);
                        continue;
                    }
                    char c = stack.peek();
                    if(c == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
            String ans = stack.isEmpty() ? "YES" : "NO";
            sb.append(ans).append("\n");
            stack.clear();
        }
        System.out.print(sb);
    }
}
