//BOJ2108. 통계학
//정렬
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //산술평균 Math.round
        double sum = 0.0;       //double 쓰자 ..... !!!!!!
        for (int i :
                arr) {
            sum+=i;
        }
        System.out.println(sum/n);
        sb.append(Math.round(sum/n)).append("\n");

        //중앙값
        Arrays.sort(arr);   //배열 정렬
        sb.append(arr[n/2]).append("\n");

        //최빈값 - 계수 정렬
        int[] toSearchFreq = new int[8001]; //-4000~4000
        for (int i :
                arr) {
            toSearchFreq[i+4000]++;
        }
        //여러값일 때를 고려해 배열 하나 더 생성
        int max = 1;
        ArrayList<Integer> freqNum = new ArrayList<>();
        for (int i = 0; i < toSearchFreq.length; i++) {
            if(toSearchFreq[i] >= max) {
                //같을 때 - 최빈값 리스트에 추가
                if(toSearchFreq[i] == max) {
                    freqNum.add(i-4000);    //최빈값
                } else {    //더 클때 비우고 추가
                    freqNum.clear();
                    freqNum.add(i-4000);
                }
                max = toSearchFreq[i];  //빈도 수
            }
        }
        Collections.sort(freqNum);
        //하나 있으면 처음꺼 꺼내고, 여러개 있으면 정렬했으니 2번째 수 꺼낸다
        int freq = freqNum.size() > 1 ? freqNum.get(1) : freqNum.get(0);
        sb.append(freq).append("\n");

        //범위
        sb.append(arr[n-1] - arr[0]);

        //출력
        System.out.println(sb);
        br.close();
    }
}
