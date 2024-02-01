package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413_단어뒤집기2 {
    private static final char SPACE = ' ';
    private static final char OPEN_TAG = '<';
    private static final char CLOSE_TAG = '>';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        /*
        후입선출 > 스택쓰자
        '<' 얘가 들어오기 전까지 스택에 넣는다. 들어오는 순간 스택에 있던것들을 빌더에 빼서 저장.
        '>' 들어올때까지 그대로 빌더에 저장
         */
        System.out.println(reverseWord(input));
    }

    private static String reverseWord(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < S.length()) {
            char c = S.charAt(idx);

            if(c == SPACE) {
                popStack(stack, sb);
                sb.append(SPACE);
            } else if(c == OPEN_TAG) {
                popStack(stack, sb);
                idx = addTag(S, sb, idx);
            } else {
                stack.push(c);
            }
            idx++;
        }
        popStack(stack, sb);
        return sb.toString();
    }

    private static void popStack(Stack<Character> s, StringBuilder sb) {
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
    }

    private static int addTag(String s, StringBuilder sb, int startIdx) {
        int endIndex = s.indexOf(CLOSE_TAG, startIdx);
        sb.append(s, startIdx, endIndex+1);
        return endIndex;
    }
}
