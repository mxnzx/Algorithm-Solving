package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String init = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < init.length(); i++) {
            leftStack.push(init.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            switch (str.charAt(0)) {
                case 'P':
                    char input = str.charAt(2);
                    leftStack.push(input);
                    break;
                case 'L':
                    if(leftStack.isEmpty()) continue;
                    rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(rightStack.isEmpty()) continue;
                    leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if(leftStack.isEmpty()) continue;
                    leftStack.pop();
                    break;
            }
        }
        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
