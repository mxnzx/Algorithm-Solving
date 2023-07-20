package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7567_그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int result = 10;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i]) result += 5;
            else result += 10;
        }
        System.out.println(result);
    }
}
