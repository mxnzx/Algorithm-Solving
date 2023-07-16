package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, Float> score = new HashMap<>();
        score.put("A+", 4.5F);
        score.put("A0", 4.0F);
        score.put("B+", 3.5F);
        score.put("B0", 3.0F);
        score.put("C+", 2.5F);
        score.put("C0", 2.0F);
        score.put("D+", 1.5F);
        score.put("D0", 1.0F);
        score.put("F", 0.0F);

        float cnt=0.0F;
        float sum=0;
        for (int tc = 0; tc < 20; tc++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            float credit = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            if(grade.equals("P")) continue;
            sum += credit * score.get(grade);
            cnt += credit;
        }
        System.out.println(sum/cnt);
    }
}
