package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            boolean isError = false;    // 중간에 에러 났으면 true. 후처리 위함.
            boolean pollFirst = true;    // 플래그를 두어 앞에서부터 빼는지, 뒤에서부터 빼는지 결정한다.
            String orders = br.readLine();
            orders = orders.replaceAll("RR","");    // RR 은 제자리이므로 제외한다.
            // 배열 받아서 전처리 해준다.
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length()-1);
            StringTokenizer st = new StringTokenizer(input, ",");
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            // str 돌면서 명령어 실행
            for (int i = 0; i < orders.length(); i++) {
                char c = orders.charAt(i);
                if(c == 'R') {
                    pollFirst = !pollFirst;    //플래그 전환.
                } else {
                    if(deque.isEmpty()) {
                        sb.append("error").append("\n");
                        isError = true;
                        break;
                    }
                    if(pollFirst) deque.pollFirst();
                    else deque.pollLast();
                }
            }
            if(isError) continue;
            sb.append("[");
            if(!deque.isEmpty()) {
                while(!deque.isEmpty()) {
                    if(pollFirst) sb.append(deque.pollFirst()).append(",");
                    else sb.append(deque.pollLast()).append(",");
                }
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}