package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];
        String input;
        while(!(input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            //삼각형 조건 체크
            if(arr[2] >= arr[0] + arr[1]) {
                sb.append("Invalid").append("\n");
                continue;
            }
            String result;
            if(arr[0]==arr[1] && arr[1]==arr[2]) result="Equilateral";
            else if(arr[0] == arr[1] || arr[1] == arr[2]) result="Isosceles";
            else result="Scalene";

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
