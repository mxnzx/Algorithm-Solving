package solution;

import java.util.Scanner;

public class BOJ1065 {
    //한수의 개수 출력 메소드
    static int hansuCnt(int n) {

        if (n==1000) n=999;
        int cnt=99;
        // 100부터 n까지 반복
        for (int i = 100; i <= n; i++) {
            //자릿수 분리. 100~999 값을 구하므로 자릿수 세개 만들어주기.(1000은 어차피 해당안됨)
            int a = i % 10;         //일의 자리
            int b = (i/10) % 10;    //십의 자리
            int c = (i/100) % 10;   //백의 자리

            if(b-c == a-b) cnt++;
        }


        return cnt;
    }
    public static void main(String[] args) {
        //1~1000의 수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = n<100 ? n : hansuCnt(n);
        System.out.println(ans);
    }
}
