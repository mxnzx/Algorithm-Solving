package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14235_크리스마스선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> gift = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if(op == 0) {
                if(gift.isEmpty()) answer.append(-1);
                else answer.append(gift.poll());
                answer.append("\n");
            } else {
                for (int j = 0; j < op; j++) {
                    gift.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(answer);
    }
}
