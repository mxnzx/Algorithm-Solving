package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            int ans=0;
            int[] box = new int[100];
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(box);
            //한번돌때마다 값이 가장 큰 인덱스가 값이 가장 작은 인덱스에게 1을 넘겨줌.
            for (int i = 0; i < dump; i++) {
                box[box.length-1]--;
                box[0]++;
                Arrays.sort(box);
                if(box[box.length-1]-box[0] <= 1) break;
            }
            ans = box[box.length-1]-box[0];

            System.out.println("#" + t + " " + ans);
        }
    }
}
