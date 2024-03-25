package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        List<Character> password = new LinkedList<>();
        ListIterator<Character> cursor = password.listIterator();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '-':
                    if (!cursor.hasPrevious()) continue;
                    cursor.previous();      //이전 요소로 이동 후 반환
                    cursor.remove();        //반환된 마지막 요소를 제거함
                    break;
                case '<':
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case '>':
                    if (cursor.hasNext()) cursor.next();
                    break;
                default:
                    cursor.add(c);      //현재 위치에 요소 추가
                    break;
            }
        }
        for(Character c : password) {
            answer.append(c);
        }
        answer.append("\n");
    }
}