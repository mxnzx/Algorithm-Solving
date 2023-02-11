/*
 * BOJ2164. 카드2
 * 구현 - 큐
 */

package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    static int N, Ans;
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //1~N까지 큐에 담는다.
        //front를 poll하고 그 다음 front를 빼고 다시 큐에 넣는다  ( rear로 가겠지)
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        while(q.size() > 1) {
            q.poll();
            //q에 남은 원소가 하나이면 탈출
            if (q.size() == 1) break;
            int tmp = q.poll();
            q.offer(tmp);
        }

        Ans = q.poll();


        System.out.println(Ans);

    }
}
