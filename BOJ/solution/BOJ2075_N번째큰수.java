//조건문 쓰기 전에 생각하고 짜자,,

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2075_N번째큰수 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                q.add(num);
                if(q.size() > N) q.poll(); //오름차순 정렬이므로 제일 작은 앞에 수가 빠짐
            }
        }
        System.out.println(q.peek());

    }
}
