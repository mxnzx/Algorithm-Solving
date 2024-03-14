package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ13335_트럭 {

    static int n,w,L;
    static int[] trucks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());   //다리길이
        L = Integer.parseInt(st.nextToken());   //다리최대하중
        st = new StringTokenizer(br.readLine());
        trucks = new int[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int weightOnBridge = 0;
        int answer = 0;
        LinkedList<Integer> bridge = new LinkedList<>();
        int idx = 0;
        while(idx < n) {
            answer++;
            if(bridge.size() == w) {
                weightOnBridge -= bridge.poll();
            }

            if(trucks[idx] <= L - weightOnBridge) {
                bridge.offer(trucks[idx]);
                weightOnBridge += trucks[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        answer += w;
        System.out.println(answer);
    }
}
