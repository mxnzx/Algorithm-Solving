package solution;

import java.io.*;
import java.util.*;

public class BOJ2621_카드게임 {
    static final int pickCnt = 5;
    static char[] colors = new char[pickCnt];
    static int[] nums = new int[pickCnt];

    static int[] copy() {
        int[] cpNums = new int[pickCnt];
        for (int i = 0; i < pickCnt; i++) {
            cpNums[i] = nums[i];
        }
        return cpNums;
    }

    static boolean isSeq(int[] sortNum) {
        Arrays.sort(sortNum);
        int prev = sortNum[0];
        for (int i = 1; i < pickCnt; i++) {
            if (sortNum[i] != prev + 1) return false;
            prev = sortNum[i];
        }
        return true;
    }

    static boolean isSame() {
        char firstColor = colors[0];
        for (int i = 1; i < pickCnt; i++) {
            if(firstColor != colors[i]) return false;
        }
        return true;
    }

    static int getScore() {

        int[] sortNums = copy();
        int[] tmp = new int[10];
        for (int i = 0; i < pickCnt; i++) {
            tmp[nums[i]]++;
        }

        // rule 1
        if(isSame() && isSeq(sortNums)) return 900 + sortNums[pickCnt - 1];

        // rule 2
        for (int i = 1; i < tmp.length; i++) {
            if(tmp[i] == 4) return 800 + i;
        }

        // rule3
        int flag1 = -1, flag2 = -1;
        for (int i = 1; i < tmp.length; i++) {
            if(tmp[i] == 3) flag1 = i;
            if(tmp[i] == 2) flag2 = i;
        }
        if(flag1 != -1 && flag2 != -1) return 700 + 10 * flag1 + flag2;

        // rule 4
        if(isSame()) return 600 + sortNums[pickCnt - 1];

        // rule 5
        if(isSeq(sortNums)) return 500 + sortNums[pickCnt - 1];

        // rule 6
        flag1 = -1;
        for (int i = 1; i < tmp.length; i++) {
            if(tmp[i] == 3) flag1 = i;
        }

        if(flag1 != -1) return 400 + flag1;

        // rule 7
        flag1 = -1;
        flag2 = -1;
        for (int i = 1; i < tmp.length; i++) {
            if(flag1 == -1 && tmp[i] == 2) {
                flag1 = i;
                continue;
            }
            if(flag2 == -1 && tmp[i] == 2) flag2 = i;
        }
        if(flag1 != -1 && flag2 != -1) return 300 + flag2 * 10 + flag1;

        // rule 8
        if(flag1 != -1 && flag2 == -1) return 200 + flag1;

        // rule 9
        return 100 + sortNums[pickCnt - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // card: R B Y G 4 colors & 1-9 num & cnt: 36(4*9)
        // pick 5 cards
        for (int i = 0; i < pickCnt; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i] =  st.nextToken().charAt(0);
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getScore());
    }
}
