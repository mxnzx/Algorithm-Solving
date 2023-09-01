package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.contains("push")) {
                st = new StringTokenizer(str);
                String cmd = st.nextToken();
                int X = Integer.parseInt(st.nextToken());
                if(cmd.equals("push_front")) deque.offerFirst(X);
                else deque.offerLast(X);
            }
            switch (str) {
                case "pop_front":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(deque.peekLast()).append("\n");
                    break;
                default:
                    break;
            }

        }
        System.out.println(sb);

    }
}
