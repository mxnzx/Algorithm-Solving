package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2529_부등호 {
    static int k;
    static char[] arr;
    static boolean[] min, max;
    static String minAns, maxAns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        min = new boolean[10];
        max = new boolean[10];
        String input = br.readLine();
        for (int i = 0; i < k; i++) {
            arr[i] = input.charAt(2*i);
        }
        makeMin(0,"");
        makeMax(0,"");
        System.out.println(maxAns);
        System.out.println(minAns);

    }

    private static void makeMax(int idx, String str) {
        if(idx > 1) {
            if((arr[idx-2] == '<' && str.charAt(idx-2) >= str.charAt(idx-1)) ||
                    (arr[idx-2] == '>' && str.charAt(idx-2) <= str.charAt(idx-1))) {
                return;
            }
        }
        if(str.length() == k+1) {
            if(maxAns == null) maxAns = str;
            return;
        }
        for (int i = 9; i >= 9-k; i--) {
            if(max[i]) continue;
            max[i] = true;
            str += i;
            makeMax(idx+1, str);
            max[i] = false;
            str = str.substring(0, str.length() - 1);
        }
    }

    private static void makeMin(int idx, String str) {
        if(idx > 1) {
            if((arr[idx-2] == '<' && str.charAt(idx-2) >= str.charAt(idx-1)) ||
                    (arr[idx-2] == '>' && str.charAt(idx-2) <= str.charAt(idx-1))) {
                return;
            }
        }
        if(str.length() == k+1) {
            if(minAns == null) minAns = str;
            return;
        }
        for (int i = 0; i <= k; i++) {
            if(min[i]) continue;
            min[i] = true;
            str += i;
            makeMin(idx+1, str);
            min[i] = false;
            str = str.substring(0, str.length() - 1);
        }
    }
}
