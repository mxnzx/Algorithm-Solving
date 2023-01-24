//SWEA 1940. 가랏! RC카
//구현
//제어문

package solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1940 {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int ans=0;
            int n = sc.nextInt();
            int v = 0 ; //현재속도
            int nv = 0;

            for (int i = 0; i < n; i++) {
                int cmd = sc.nextInt();
                if(cmd != 0) {
                    nv = sc.nextInt();
                }
                switch(cmd){
                    case 0:
                        ans += v;
                        break;
                    case 1:
                        v+=nv;
                        ans += v;
                        break;
                    case 2:
                        if(nv > v) {
                            v = 0;
                            break;
                        }
                        v-=nv;
                        ans += v;
                        break;
                }
            }
            System.out.println("#" + t + " "+ ans);
        }
    }
}
