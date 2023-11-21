package solution;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> car = new ArrayList<>();
        // 대근이 - 차가 들어가는 순서대로
        for (int i = 0; i < N; i++) {
            car.add(br.readLine());
        }
        // 영식이 - 나오는 순서대로.
        int cnt=0;
        for (int i = 0; i < N; i++) {
            String order = car.get(0);
            String outCar = br.readLine();
            if(outCar.equals(order)) {
                car.remove(0);
            } else {
                cnt++;
                car.remove(outCar);
            }
        }
        System.out.println(cnt);
    }
}
