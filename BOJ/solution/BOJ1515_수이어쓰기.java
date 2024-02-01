package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1515_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        /*
        수가 항상 오름차순이어야한다.
        0~9를 각자리에 넣어보며 비교해도 최대 30000 이내에서 찾아진다
        브루트포스로 찾는다.
        필요한 변수: 현재 수를 가리킬 포인터. 최솟값이 얼만지 알아낼 base 깂
         */
        int pt = 0, base = 0;
        while(base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                // 현재 base 수를 하나씩 떼어 포인터와 비교한다. 이때 포인터와 겹치는 것이 있으면 포인터 다음으로 넘김.
                if(tmp.charAt(i) == input.charAt(pt)) pt++;
                //끝까지 왔으면 base 를 출력하면 된다.
                if(pt == input.length()) {
                    System.out.println(base);
                    return;
                }
            }

        }
    }
}
