package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1417_국회의원선거 {
    static int N;

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> vote = new PriorityQueue<>(Comparator.reverseOrder());

        int dasomVote = Integer.parseInt(br.readLine());

        for (int i = 0; i < N-1; i++) {
            vote.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while(!vote.isEmpty()) {
            int now = vote.poll();
            if(dasomVote > now) {
                break;
            }

            vote.offer(now-1);
            dasomVote++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
