package solution;

import java.util.*;
import java.io.*;

public class BOJ1461_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] books = new int[N];
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(books);

        boolean isFarLeft;
        // 둘다 음수 or 양수
        if (books[0] * books[books.length - 1] > 0) {
            isFarLeft = books[0] < 0;
        } else {
            isFarLeft = books[0] * (-1) - books[books.length - 1] > 0;
        }

        int ans = 0;
        // 왼쪽 탐색
        int idx = 0;
        boolean isFarRight = !isFarLeft;
        while(idx < books.length && books[idx] < 0) {
            if(isFarLeft) {
                ans += books[idx] * (-1);
                isFarLeft = false;
            } else {
                ans += books[idx] * 2 * (-1);
            }
            idx += M;
        }
        // 오른쪽 탐색
        idx = books.length - 1;
        while (idx >= 0 && books[idx] > 0) {
            if(isFarRight) {
                ans += books[idx];
                isFarRight = false;
            } else {
                ans += books[idx] * 2;
            }
            idx -= M;
        }
        System.out.println(ans);
    }
}
