package solution;

import java.io.*;

public class BOJ8595_히든넘버 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int serialCnt = 0;
        int hiddenNumber = 0;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(c >= '0' && c <= '9') {
                hiddenNumber *= 10;
                hiddenNumber += (c - '0');
                serialCnt++;
            } else {
                if(serialCnt > 0 && serialCnt <= 6) {
                    sum += hiddenNumber;
                }
                serialCnt = 0;
                hiddenNumber = 0;
            }
        }
        if(serialCnt > 0 && serialCnt <= 6) {
            sum += hiddenNumber;
        }
        System.out.println(sum);

    }
}
