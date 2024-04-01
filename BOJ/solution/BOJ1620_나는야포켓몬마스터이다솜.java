package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620_나는야포켓몬마스터이다솜 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<Integer, String> dogamById = new HashMap<>();
        Map<String, Integer> dogamByName = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dogamById.put(i, name);
            dogamByName.put(name, i);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
//            try {
//                int n = Integer.parseInt(input);
//                answer.append(dogamById.get(n));
//            } catch (NumberFormatException e) {
//                answer.append(dogamByName.get(input));
//            } finally {
//                answer.append("\n");
//            }
            if(Character.isDigit(input.charAt(0))) {
                int n = Integer.parseInt(input);
                answer.append(dogamById.get(n));
            } else {
                answer.append(dogamByName.get(input));
            }
            answer.append("\n");
        }
        System.out.println(answer);


    }
}
