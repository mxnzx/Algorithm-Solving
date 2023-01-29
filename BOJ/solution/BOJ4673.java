package solution;

public class BOJ4673 {
    static final int val = 10000;
    static boolean[] selfNum = new boolean[val];

    //셀프넘버인지 구분해주는 배열 관리 메서드
    static void flag(int n) {
        selfNum[n-1] = true;
    }

    //n과 각 자리를 더하는 메서드
    static void d(int n) {
        //자릿수 하나씩 떼어서 sum에 더해줌 - 순서 주의 !!! n/=10 먼저하면 n의 값이 변경됨.
        int sum = n;
        while(n>0) {
            sum+=n%10;
            n/=10;
        }
        //sum이 지정해준 값을 넘으면 메소드 빠져나옴
        if(sum>=val) return;
        flag(sum);
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        //모든 수를 탐색한다
        for (int i = 1; i < val; i++) {
            d(i);
        }
        //생성자가 없는 숫자들을 출력한다
        for (int i = 0; i < val-1; i++) {
            if(!selfNum[i])
                sb.append(i+1).append("\n");
        }
        System.out.println(sb);
    }
}
