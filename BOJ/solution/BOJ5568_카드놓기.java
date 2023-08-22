package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ5568_카드놓기 {
    static int[] cards;
    static Map<String, Integer> results;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        cards = new int[n];
        results = new HashMap<>();
        for (int i = 0; i < n; i++) {
           cards[i] = Integer.parseInt(br.readLine());
        }
        perm(0, new int[k], 0, new boolean[n]);
        System.out.println(results.size());

    }

    private static void perm(int idx, int[] sel, int selected, boolean[] visited) {

        if(selected == sel.length) {
            //sel 배열의 정수를 문자열로 바꾼 후 result[idx]에 추가한다
            String str = "";
            for (int s : sel) {
                str += String.valueOf(s);
            }
            results.put(str, 1);

            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if(visited[i]) continue;
            sel[selected] = cards[i];
            visited[i] = true;
            perm(i+1, sel, selected+1, visited);
            visited[i] = false;
        }
    }
}
