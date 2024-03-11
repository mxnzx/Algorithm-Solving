package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278_스택2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int order = input.charAt(0) - '0';
            if(order == 1) {
                stack.push(Integer.valueOf(input.substring(2)));
                continue;
            } else if(order == 2) {
                if(stack.isEmpty()) sb.append(-1);
                else sb.append(stack.pop());
            } else if(order == 3) {
                sb.append(stack.size());
            } else if (order == 4) {
                if(stack.isEmpty()) sb.append(1);
                else sb.append(0);
            } else {
                if(stack.isEmpty()) sb.append(-1);
                else sb.append(stack.peek());
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
