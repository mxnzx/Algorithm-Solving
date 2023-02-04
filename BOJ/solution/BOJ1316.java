//BOJ1316. 그룹 단어 체커
//조건문, 문자열

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            //한번 입력된 알파벳을 flag를 통해 받아놓고 다음에 또 들어오면 count 하지않고 넘어간다. - 계수 정렬 활용
            int[] alphabet = new int[26];

            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char current = str.charAt(j);
                int currentToInt = (int)current-'a';
                //앞에 문자가 있고, 그게 지금이랑 같으면 다음 문자로 넘어감
                if((j > 0) && (str.charAt(j-1) == current) ) {

                    //문자열을 다 돌았으면 카운트 업
                    if (str.length() == j + 1)
                        cnt++;
                    continue;
                }
                //알파벳이 처음나오는 문자라면 flag 변경 (0 -> 1)
                if(alphabet[currentToInt] != 1) {
                    alphabet[currentToInt]++;

                    if (str.length() == j + 1)
                        cnt++;
                } else {
                    //이전 문자와 동일하지 않고, 처음나오는 문자도 아니면 그룹단어가 아니므로 다음 테케로 넘어간다.
                    break;
                }
                //문자열을 다 돌았는데 위의 두 조건문에 해당하지 못하면 cnt가 올라가지 않고 다음 테케로 넘어간다
            }
        }
        System.out.println(cnt);
        br.close();
    }

}
