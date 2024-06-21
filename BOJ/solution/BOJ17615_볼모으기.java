package solution;

import java.io.*;

public class BOJ17615_볼모으기 {

    static int moveLeft(char movingColor, char otherColor) {
        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == otherColor) {
                for (int j = i + 1; j < input.length; j++) {
                    if(input[j] == movingColor) cnt++;
                }
                break;
            }
        }

        return cnt;
    }

    static int moveRight(char movingColor, char otherColor) {
        int cnt = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            if(input[i] == otherColor) {
                for (int j = i - 1; j >= 0; j--) {
                    if(input[j] == movingColor) cnt++;
                }
                break;
            }
        }

        return cnt;
    }

    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        input= br.readLine().toCharArray();
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, moveLeft('B', 'R'));
        ans = Math.min(ans, moveLeft('R', 'B'));
        ans = Math.min(ans, moveRight('B', 'R'));
        ans = Math.min(ans, moveRight('R', 'B'));

        System.out.println(ans);
    }
}