package solution;

import java.util.*;
import java.io.*;

public class BOJ1755_숫자놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        final String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Integer> stringToInt = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            stringToInt.put(words[i], i);
        }

        String[] nums = new String[M - N + 1];
        for (int i = N, j = 0; i <= M; i++, j++) {
            if(i < 10) {
                nums[j] = words[i];
            } else {
                int first = i / 10;
                int second = i % 10;
                nums[j] = words[first] + " " + words[second];
            }
        }
        Arrays.sort(nums);
        // 다시 원래로 돌린다.
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            st = new StringTokenizer(nums[i]);
            while(st.hasMoreTokens()) {
                ans.append(stringToInt.get(st.nextToken()));
            }
            ans.append(" ");
            if((i+1) % 10 == 0) ans.append("\n");
        }
        System.out.println(ans);
    }
}
