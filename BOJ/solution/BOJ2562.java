package solution;

import java.io.*;
import java.util.ArrayList;

public class BOJ2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> aList = new ArrayList<>();
        String num;
        int i=0;
        int max=0;
        int maxIdx=0;
        while((num=(br.readLine())) != null) {
            aList.add(Integer.parseInt(num));
            if(max <= aList.get(i)) {
                max = aList.get(i);
                maxIdx = i+1;
            }

            i++;
        }
        System.out.println(max);
        System.out.println(maxIdx);
    }
}

