package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : input) {
                if (stack.isEmpty()) {
                    stack.add(c);
                    if (c == ')') break;
                    continue;
                }
                if (stack.peek() == c) stack.add(c);
                else stack.pop();
            }
            String answer = (stack.isEmpty()) ? "YES" : "NO";
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
