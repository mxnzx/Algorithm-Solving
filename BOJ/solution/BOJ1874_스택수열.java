package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] results = new int[n+1];
        for (int i = 1; i <= n; i++) {
            results[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        boolean isSuccess = false;
        int currentNum = 1;
        for (int i = 1; i <= n; i++) {
            int now = results[i];
            int top = stack.isEmpty() ? 0 : stack.peek();
            if(now < top) break;
            if(now > top) {
                while(currentNum <= now) {
                    stack.push(currentNum++);
                    sb.append("+").append("\n");
                }
            }
            if(stack.peek() == now) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                break;
            }
            if(i == n && stack.isEmpty()) isSuccess = true;
        }
        System.out.println(isSuccess ? sb : "NO");
    }
}
