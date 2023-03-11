/*
 * [BOJ]8320. 직사각형을만드는방법 - 구현
 */
package solution;

import java.util.Scanner;

public class BOJ8320_직사각형을만드는방법 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt=0;
        //굳이 while이 아닌 for문으로 돌린 이유는 i,j 변수를 반복문내부에서 올리기 위함
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            for (int j = i; j <= n; j++) {
                if(i*j <= n) {
                    cnt++;
                    //조건 만족했으면 카운팅하고 다음 반복문으로
                    continue;
                }
                //위의 조건을 통과하지 못하면 바로 나옴
                break;
            }
        }
        //이중반복문을 어떻게 짜느냐에 따라 실행횟수가 크게 달라질 수 있음.
        System.out.println(cnt);
    }
}
