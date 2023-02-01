//계수 정렬

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2000002];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        int x = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < x; i++) {
            if(arr[i] == 1) {
                int searchNum = x - i;
                //searchNum 값이 그 뒤에 있다면 count++
                if(arr[searchNum] == 1)
                    count++;
            }
        }

        //중복된 count 빼줌
        System.out.println(count/2);
    }

}
