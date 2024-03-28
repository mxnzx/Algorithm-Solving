package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ4195_친구네트워크 {

    static int[] parents, level;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<String, Integer> people = new HashMap<>();
            int idx = 0;
            int F = Integer.parseInt(br.readLine());
            String[][] input = new String[F][2];
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                if (!people.containsKey(f1)) people.put(f1, idx++);
                if (!people.containsKey(f2)) people.put(f2, idx++);
                input[i][0] = f1;
                input[i][1] = f2;
            }

            makeDisjointSet(people, input);
        }
        System.out.println(answer);
    }

    private static void makeDisjointSet(Map<String, Integer> people, String[][] input) {

        parents = new int[people.size()];
        level = new int[people.size()];
        Arrays.fill(level, 1);
        for (int i = 0; i < people.size(); i++) {
            parents[i] = i;
        }

        for (int i = 0; i < input.length; i++) {
            int f1 = people.get(input[i][0]);
            int f2 = people.get(input[i][1]);
            answer.append(union(f1, f2)).append("\n");

            System.out.println(Arrays.toString(parents));
        }
    }

    private static int union(int f1, int f2) {
        int pa = find(f1);
        int pb = find(f2);

        if (pa != pb) { //항상 pa < pb 라고 가정. 더 작은 애를 루트로 붙임.
            parents[pb] = pa;
            level[pa] += level[pb];
        }
        return level[pa];
    }

    private static int find(int f) {
        if (f == parents[f]) return f;
        return parents[f] = find(parents[f]);
    }
}