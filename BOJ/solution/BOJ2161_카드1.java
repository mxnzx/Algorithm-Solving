package solution;

import java.util.*;
import java.io.*;

public class BOJ2161_카드1 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(N);
            return;
        }

        for (int i = 1; i <= N; i++) q.offer(i);

        Queue<Integer> end = new LinkedList<>();

        while(true) {
            end.add(q.poll());
            if(q.size() == 1) break;
            q.offer(q.poll());
        }

        StringBuilder ans = new StringBuilder();
        while(!end.isEmpty()) {
            ans.append(end.poll()).append(" ");
        }
        ans.append(q.poll());

        System.out.println(ans);
    }
}
