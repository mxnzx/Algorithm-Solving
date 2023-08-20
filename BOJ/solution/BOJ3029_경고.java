package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3029_경고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] time = new int[2][3];   //시, 분, 초
        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(),":");
            for (int j = 0; j < 3; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(time[i]));
        }
        int[] sibuncho = {23,59,60};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 0) sibuncho[j] -= time[0][j];
                if(i == 1) sibuncho[j] += time[1][j];
            }
        }
        for (int i = 2; i > 0; i--) {
            if(sibuncho[i] >= 60) {
                sibuncho[i] -= 60;
                sibuncho[i-1] += 1;
            }
        }
        if(sibuncho[0] >= 24 && ( sibuncho[1]>0 || sibuncho[2]>0)) sibuncho[0] -= 24;

        System.out.println((sibuncho[0]<10?"0"+sibuncho[0]:sibuncho[0]) + ":" + (sibuncho[1]<10?"0"+sibuncho[1]:sibuncho[1]) + ":" + (sibuncho[2]<10?"0"+sibuncho[2]:sibuncho[2]));
    }
}
