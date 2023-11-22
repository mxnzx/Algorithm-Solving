package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> nums = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > 0) {
                nums.offer(input);
            } else if (input == 0 && nums.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                sb.append(nums.poll()).append("\n");;
            }
        }
        System.out.println(sb);
    }
}
