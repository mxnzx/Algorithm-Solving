package solution;

import java.io.*;
import java.util.*;

public class BOJ2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> input = new LinkedList<>();
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            input.add(str.charAt(i) - '0');
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        while(!input.isEmpty() && cnt < K) {
            Integer now = input.poll();

            while(true) {
                if(stack.empty()) {
                    stack.push(now);
                    break;
                }

                Integer prev = stack.peek();
                if(prev < now) {
                    stack.pop();
                    cnt++;

                    if(cnt == K) {
                        stack.push(now);
                        break;
                    }
                } else {
                    stack.push(now);
                    break;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for(Integer num : stack) ans.append(num);
        while(!input.isEmpty()) ans.append(input.poll());

        System.out.println(ans.substring(0, N - K));
    }
}