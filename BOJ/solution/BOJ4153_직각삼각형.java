package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        String input;
        while(! (input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            String result;
            if((arr[0]*arr[0] + arr[1]*arr[1]) == arr[2]*arr[2]) result = "right";
            else result = "wrong";
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
