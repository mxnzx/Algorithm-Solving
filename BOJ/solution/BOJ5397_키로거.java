package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
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
        LinkedList<Character> list = new LinkedList<>();
        //커서의 위치를 가리킴. 요소를 순차적으로 읽거나 추가, 수정, 삭제 가능한 양방향 반복자
        ListIterator<Character> iter = list.listIterator();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c){
                case '-':
                    if(!iter.hasPrevious()) continue;
                    iter.previous();
                    iter.remove();
                    break;
                case '<':
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case '>':
                    if(iter.hasNext()) iter.next();
                    break;
                default:
                    iter.add(c);
                    break;
            }
            //System.out.println(iter);
        }
        for(Character c : list) {
            answer.append(c);
        }
        answer.append("\n");
    }
}