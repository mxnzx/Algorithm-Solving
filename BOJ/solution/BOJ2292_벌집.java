package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        1 - 1 (1)1
        2 - 2~7 (6)
        3 - 8~19(12)
        4 - 20~37(18)
         */
        int num = 1;
        int depth = 1;
        while(true) {
            num = num + 6*(depth-1);
            if(N <= num) {
                System.out.println(depth);
                return;
            }
            depth++;
        }
    }
}
