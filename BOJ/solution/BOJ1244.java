package solution;

import java.util.Scanner;

public class BOJ1244 {

    static int switchNum(int n) {
        return (n == 1) ? 0 : 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //스위치 개수
        int[] swi = new int[n];

        for (int i = 0; i < n; i++) {
            swi[i] = sc.nextInt();
        }

        int student = sc.nextInt();

        for (int i = 0; i < student; i++) {
            int gender = sc.nextInt();
            int selected = sc.nextInt();
            int num = selected - 1; //내가 고른 스위치 번호의 배열 인덱스

            switch (gender) {
                case 1:
                    for (int j = num; j < swi.length; j += selected) {
                        swi[j] = switchNum(swi[j]);
                    }
                    break;
                case 2:
                    int left = num - 1;
                    int right = num + 1;
                    //기준 스위치 먼저 바꿔줌
                    swi[num] = switchNum(swi[num]);

                    //배열 넘어가지 않을때까지 반복
                    while (left >= 0 && right < n) {
                        //대칭일때마다 체인지
                        if (swi[left] == swi[right]) {
                            swi[left] = switchNum(swi[left]);
                            swi[right] = switchNum(swi[right]);
                            left--;
                            right++;
                        } else {    //아니면 while문 탈출
                            break;
                        }
                    }
                    break;
            }
        }
        for (int i = 0; i < swi.length; i++) {
            if (i > 0 && i % 20 == 0) System.out.println();
            System.out.print(swi[i] + " ");
        }
    }

}
