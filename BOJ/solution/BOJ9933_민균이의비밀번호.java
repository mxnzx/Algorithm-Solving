package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9933_민균이의비밀번호 {
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            if(check(arr[i], i)) {
                System.out.println(arr[i].length() + " "+arr[i].charAt(arr[i].length()/2));
                System.exit(0);
            };

        }
    }
    private static boolean check(String str, int i) {
        StringBuilder sb = new StringBuilder(str);
        //펠린드롬
        if(str.equals(String.valueOf(sb.reverse()))) return true;
        //아니면 체크
        for (int j = 0; j < i; j++) {
            //System.out.println(arr[i] + " " + arr[j]);
            if (arr[i].length() != arr[j].length()) continue;
            //길이가 같다면 비교
            for (int a = 0, b = arr[i].length() - 1; a < arr[i].length(); a++, b--) {
                if (arr[i].charAt(a) != arr[j].charAt(b)) break;
                if(a == arr[i].length()-1) return true;
            }
        }
        return false;

    }
}
