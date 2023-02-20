/*
 * 대놓고 분할정복 한 곳 탐색했으면 다음 탐색구간으로 가라. 근데 이 과정이 같다 -> 재귀
 * cut()시간초과뜸.
 * 큐?
 */
package solution;

import java.util.Scanner;

public class BOJ1074_Z {

	static int N, targetR, targetC, num;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		targetR = sc.nextInt();
		targetC = sc.nextInt();

		// 다 들어가고 나올때부터 값을 올리다가 구하고자 하는 값이 나오면 출력하고 리턴.
		cut(0, 0, (int) Math.pow(2, N));

		// 2차원 배열을 만들
	}
	
	//하나씩 순회하는 방식 -> 시간 초과 뜸
//	private static void cut(int r, int c, int size) {
//		
//		if(r == targetR && c == targetC) {
//			System.out.println(Ans);
//			return;
//		}
//		//1이면 카운트를 해준다. 이게 곧 원하는 결과값임.
//		if(size == 1) Ans++;
//		
//		if(size > 0) {
//			int half = size/2;
//			cut(r, c, half);
//			
//			cut(r, c+half, half);
//			
//			cut(r+half, c, half);
//			
//			cut(r+half, c+half, half);
//			
//		}
//		
//	}

	//구간을 나누어 내가 찾는 좌표가 어디있는지 조건에 맞춰 찾아간다(좌측상단부터 시계방향으로 1,2,3,4사분면)
	private static void cut(int r, int c, int size) {
		
		if(size == 1) {			
			return;
		}
		if(targetR == r && targetC == c) {

			System.out.println(num);
			return;
		}
		

		int half = size/2;
		int tmp = (int)Math.pow(size/2,2);
		//targetR, targetC가 1사분면
		
		if(targetR < half && targetC < half) {
			System.out.println(1);
			num += ((int)Math.pow(half,2)*0);
			cut(r, c, half);
			
			
		} else if(targetR < half && targetC < size) {	//2사분면
			System.out.println(2);
			num += ((int)Math.pow(half,2)*1);
			cut(r, c + tmp, half);
			
		} else if(targetR < size && targetC < half) {	//3사분면
			System.out.println(3);
			num += ((int)Math.pow(half,2)*2);
			cut(r + tmp, c, half);
			
		} else {	//4사분면
			System.out.println(4);
			num += ((int)Math.pow(half,2)*3);
			cut(r + tmp, c + tmp, half);
		}
	}

		

}
