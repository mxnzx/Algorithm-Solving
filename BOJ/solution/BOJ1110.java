package solution;

import java.io.*;

public class BOJ1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int first, second;
        int temp;
        int cnt=0;
        int newNum = input;
        do {
            first = newNum/10;
            second = newNum%10;
            temp = first +second;
            newNum = second*10 + temp%10;
            cnt++;
        } while(input != newNum);

        System.out.println(cnt);
    }
}
