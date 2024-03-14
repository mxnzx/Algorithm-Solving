package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1063_킹 {

    static class Loc {
        int r, c;

        Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static final int[] dr = {1, 1, 1, 0, -1, -1, -1, 0};
    static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Map<String, Integer> op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        op = Map.ofEntries(
                Map.entry("LT", 0),
                Map.entry("T", 1),
                Map.entry("RT", 2),
                Map.entry("R", 3),
                Map.entry("RB", 4),
                Map.entry("B", 5),
                Map.entry("LB", 6),
                Map.entry("L", 7)
        );
        String tmpKing = st.nextToken();
        String tmpStone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        Loc king = new Loc(tmpKing.charAt(1) - '0', tmpKing.charAt(0) - 'A' + 1);
        Loc stone = new Loc(tmpStone.charAt(1) - '0', tmpStone.charAt(0) - 'A' + 1);
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int nrKing = king.r + dr[op.get(input)];
            int ncKing = king.c + dc[op.get(input)];
            int nrStone = stone.r + dr[op.get(input)];
            int ncStone = stone.c + dc[op.get(input)];

            if(checkEdge(nrKing, ncKing)) {
                if(nrKing == stone.r && ncKing == stone.c) {
                    if(checkEdge(nrStone, ncStone)) {
                        king.r = nrKing;
                        king.c = ncKing;
                        stone.r = nrStone;
                        stone.c = ncStone;
                    }
                } else {
                    king.r = nrKing;
                    king.c = ncKing;
                }
            }

        }
        System.out.println((char) (king.c + 'A' - 1) + "" + king.r);
        System.out.println((char) (stone.c + 'A' - 1) + "" + stone.r);
    }

    private static boolean checkEdge(int r, int c) {
        return r > 0 && r <= 8 && c > 0 && c <= 8;
    }
}
