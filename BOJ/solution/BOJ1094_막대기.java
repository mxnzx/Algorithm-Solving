package solution;

import java.util.*;
import java.io.*;

public class BOJ1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(64);

        while(true) {
            int current = queue.poll();
            if(X == 64) break;
            int half = current / 2;
            int sum = half;

            for(int n : queue) {
                sum += n;
            }

            if(sum == X) break;

            queue.add(half);

            if(sum < X) {
                queue.add(half);
            }
        }
        System.out.println(queue.size() + 1);

    }
}
