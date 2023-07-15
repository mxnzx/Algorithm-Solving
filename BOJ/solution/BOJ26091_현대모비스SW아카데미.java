package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ26091_현대모비스SW아카데미 {
    static int N,M;
    static int[] student;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        student = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        //배열을 정렬한 후 시작점/끝점을 잡고 개수를 확인한다
        Arrays.sort(student);
        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        if(student.length == 1) return 0;
        int start=0, end=student.length-1;
        int cnt=0;
        while(start < end) {
            int sum = student[start] + student[end];
            if(sum < M) {
                start++;
            } else {
                cnt++;
                start++;
                end--;
            }
        }
        return cnt;
    }
}
