package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ5397_키로거 {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            // 백스페이스(-) > 글자가 있었다면 글자 지운다.
            // 화살표(<, >) > 움직일 수 있었다면 1만큼 움직인다
            solution(input);
        }
        System.out.println(answer);
    }

    private static void solution(String input) {
        int cursor = 0;
        Stack<Character> front = new Stack<>();
        Stack<Character> back = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c){
                case '-':
                    if(!front.empty()) front.pop();
                    break;
                case '<':
                    if(!front.empty()) back.push(front.pop());
                    break;
                case '>':
                    if(!back.empty()) front.push(back.pop());
                    break;
                default:
                    front.push(c);
                    break;
            }
        }
        while(!back.empty()) {
            front.push(back.pop());
        }
        for(Character c : front) {
            answer.append(c);
        }
        answer.append("\n");
    }
}