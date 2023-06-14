package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273_두수의합_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int count = 0, start=0, end=arr.length-1, sum;
        while(start<end) {
            sum = arr[start] + arr[end];
            if(sum == x) {
                start++;
                end--;
                count++;
            }
            else if (sum > x) end--;
            else start++;

        }
        System.out.println(count);
    }
}
