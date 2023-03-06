/*
 * [SWEA]2115_벌꿀채취
 * 조합론 - 조합, 부분집합
 * 놓친 부분: 재귀 돌릴 때, 기저조건에서 리턴 까먹지 말기 !!!! 제발 
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2115_벌꿀채취 {


    static int T,N,M,C;
    static int[][] map,maxMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());   //벌통 개수
            C = Integer.parseInt(st.nextToken());   //채취 가능한 꿀의 양

            map = new int[N][N];
            maxMap = new int[N][N];		//r,c위치에서 연속된 M개의 벌통을 놓았을 경우 최대 수익, 0으로 초기화된 상태
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(tc).append(" ").append(getMaxBenefit()).append("\n");

        }
        
        
        
        System.out.println(sb);
    }

	private static int getMaxBenefit() {
		//각 구간에서 나올 수 있는 최대값을 가지고 왔다.
		makeMaxMap();	
		return processComb();
	}
	//a일꾼과 b일꾼이 선택할 구간을 조합을 통해 찾아낸다
	private static int processComb() {
		int max = 0, aBenefit = 0, bMaxBenefit;
		
		for (int i = 0; i < N; i++) {	
			for (int j = 0; j < N-M+1; j++) {
				aBenefit = maxMap[i][j];	//a일꾼 선택
				
				bMaxBenefit = 0;
				//선택한 a일꾼에 대해 b일꾼이 가질 수 있는 최대 값을 고르게 한다 (조합)
				//경우의 수1. 같은 행의 뒷쪽 열
				for (int j2 = j+M; j2 < N-M+1; j2++) {
					if(bMaxBenefit < maxMap[i][j2]) bMaxBenefit = maxMap[i][j2];
				}
				//경우의 수2. 다른 행의 첫열부터
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N-M+1; j2++) {
						if(bMaxBenefit < maxMap[i2][j2]) bMaxBenefit = maxMap[i2][j2];
					}
				}
				if(max < aBenefit + bMaxBenefit) max = aBenefit + bMaxBenefit;
				
			}
		}
		
		return max;
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {	//연속된 M개를 만들수 있는 위치마다 연속 M개로 만들 수 있는 부분집합의 최대 이익 계산
			for (int j = 0; j < N-M+1; j++) {
				makeMaxSubset(i,j,0,0,0);
			}
		}
		
	}
	//부분집합
	//cnt: 몇개 골랐는지 관리하는 카운팅 변수.   sum: C를 넘는지 관리하는 변수.    powSum: 마지막 결과값을 나타내는 합계 변수
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {

		//기저조건
		if(sum > C) return;
		//다 마치고 들어온 애들
		if(cnt == M) {
			//현재가지고 온 합계가 기존보다 크면 갱신
			if (maxMap[i][j-M] < powSum) maxMap[i][j-M] = powSum;
			return;
		}
		//선택
		makeMaxSubset(i,j+1,cnt+1, sum+map[i][j], powSum + map[i][j]*map[i][j]);		
		//비선택
		makeMaxSubset(i,j+1,cnt+1, sum, powSum);
	}
	

}
