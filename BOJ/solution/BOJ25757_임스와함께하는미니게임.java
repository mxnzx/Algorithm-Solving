package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ25757_임스와함께하는미니게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        Set<String> users = new HashSet<>();
        for (int i = 0; i < N; i++) {
            users.add(br.readLine());
        }
        gaming(game, users.size());

    }
    static void gaming(char game, int userCnt) {
        int canPlayCnt = 0;
        switch (game) {
            case 'Y':
                canPlayCnt = userCnt;
                break;

            case 'F':
                canPlayCnt = userCnt / 2;
                break;

            case 'O':
                canPlayCnt = userCnt / 3;
                break;
        }
        System.out.println(canPlayCnt);
    }
}
