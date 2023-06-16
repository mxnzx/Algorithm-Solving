package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ3699_주차빌딩 {
    static class Car implements Comparable<Car>{
        int r,c,val;

        public Car(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "r=" + r +
                    ", c=" + c +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Car o) {
            return this.val - o.val;
        }
    }
    static int T, h, l;
    static ArrayList<Car> cars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            cars = new ArrayList<>();
            cars.add(new Car(1,1,0)); //맨 처음 위치 삽입
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= l; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num != -1) cars.add(new Car(i,j,num));
                }
            }
            Collections.sort(cars);
            System.out.println(cars);
            //내 다음과 차이를 계산해서 더한다
            int sum = 0;
            for (int i = 1; i < cars.size(); i++) {
                //층수 계산
                Car now = cars.get(i);
                Car prev = cars.get(i-1);
                int height = 2*(now.r - 1);
                System.out.println("now " + now.c);
                System.out.println("prev " + prev.c);
                System.out.println(">>>" +Math.abs(now.c-prev.c) + " " + (l-Math.max(now.c, prev.c) + Math.min(now.c, prev.c)));
                int length = Math.min(Math.abs(now.c-prev.c), l-Math.max(now.c, prev.c) + Math.min(now.c, prev.c));
                sum  = sum + height*10 + length*5;
                System.out.println(height + " "+ length);
                // 1 2 3 4 5 6      5-1     (6-5)+(1) 6-4+2
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
