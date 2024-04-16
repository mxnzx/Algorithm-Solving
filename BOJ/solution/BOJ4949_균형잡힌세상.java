package solution;

import java.util.*;
import java.io.*;

public class BOJ4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder ans = new StringBuilder();
        Stack<Character> bracket;
        while(!(input = br.readLine()).equals(".")) {
            bracket = new Stack<>();
            char[] inputToArr = input.toCharArray();
            boolean isBalance = true;
            for(char c : inputToArr) {
                if(c == '(' || c == '[') {
                    bracket.push(c);
                    continue;
                }

                if(c == ')') {
                    if(bracket.empty() || bracket.pop() != '(') {
                        isBalance = false;
                        break;
                    }
                }

                if(c == ']') {
                    if(bracket.empty() || bracket.pop() != '[') {
                        isBalance = false;
                        break;
                    }
                }
            }
            if(isBalance && !bracket.empty()) isBalance = false;
            ans.append(isBalance ? "yes" : "no").append("\n");
        }
        System.out.println(ans);
    }
}
