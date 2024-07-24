package solution;

import java.util.*;
import java.io.*;

public class BOJ7662_이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            PriorityQueue<Integer> pqOrderByASC = new PriorityQueue<>();
            PriorityQueue<Integer> pqOrderByDESC = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> dict = new HashMap<>();    // 키:큐의 들어간 원소값 값:몇 개 들어가있냐
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if (op == 'I') {
                    // 두 큐에 n을 둘 다 넣고, dict 갱신한다.
                    pqOrderByDESC.offer(n);
                    pqOrderByASC.offer(n);
                    dict.put(n, dict.getOrDefault(n, 0) + 1);
                } else {
                    if(dict.isEmpty()) continue;

                    if(n == 1) {
                        updateDict(pqOrderByDESC, dict);
                    } else {
                        updateDict(pqOrderByASC, dict);
                    }
                }
            }

            String res;
            if(dict.isEmpty()) {
                res = "EMPTY";
            } else {
                int max = updateDict(pqOrderByDESC, dict);
                int min = dict.isEmpty() ? max : updateDict(pqOrderByASC, dict);
                res = max + " " + min;
            }
            ans.append(res).append("\n");
        }
        System.out.println(ans);
    }

    static int updateDict(PriorityQueue<Integer> pq, Map<Integer, Integer> dict) {

        int num;
        while(true) {
            num = pq.poll();
            int cnt = dict.getOrDefault(num, 0);

            if(cnt == 0) continue;
            if(cnt == 1) dict.remove(num);
            else dict.replace(num, cnt - 1);

            break;
        }

        return num;
    }
}