package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder ans = new StringBuilder();
        while(!(input = br.readLine()).equals("0")) {
            Stack<Character> s = new Stack<>();
            int length = input.length();
            for (int i = 0; i < length / 2; i++) {
                s.push(input.charAt(i));
            }
            boolean isSuccess = true;
            for (int i = (length+1)/2; i < length; i++) {
                if(input.charAt(i) != s.pop()) {
                    isSuccess = false;
                    break;
                }
            }
            ans.append(isSuccess ? "yes" : "no").append("\n");
        }
        System.out.println(ans);
    }
}
