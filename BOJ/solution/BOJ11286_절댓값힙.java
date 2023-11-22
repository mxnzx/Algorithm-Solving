package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286_절댓값힙 {
    public static class Num implements Comparable<Num> {
        int originalNum;
        int absNum;

        public Num(int originalNum, int absNum) {
            this.originalNum = originalNum;
            this.absNum = absNum;
        }

        @Override
        public int compareTo(Num o) {

            if(this.absNum != o.absNum) {
                return this.absNum - o.absNum;
            } else {
                return this.originalNum - o.originalNum;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Num> nums = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                nums.offer(new Num(input, Math.abs(input)));
            } else if (nums.isEmpty()) {
                sb.append(0).append("\n");
            } else {    // input == 0
                sb.append(nums.poll().originalNum).append("\n");
            }
        }
        System.out.println(sb);
    }
}
