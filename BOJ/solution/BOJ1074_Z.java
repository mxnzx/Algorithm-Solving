/* [BOJ]1074. Z
 * 대놓고 분할정복 한 곳 탐색했으면 다음 탐색구간으로 가라. 근데 이 과정이 같다 -> 재귀
 * 분할정복할때 메모리, 시간 생각하고, 무턱대고 재귀를 돌리는게 아니라 조건을 걸어 그 부분만 재귀를 돌릴수있으면 그렇게 하기
 * 그리고 범위 설정에 유의하자..
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {

	static int N, targetR, targetC, num=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		targetR = Integer.parseInt(st.nextToken());
		targetC = Integer.parseInt(st.nextToken());
		// 다 들어가고 나올때부터 값을 올리다가 구하고자 하는 값이 나오면 출력하고 리턴.
		cut(0, 0, (int) Math.pow(2, N));
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
	//구간을 나누어 내가 찾는 좌표가 어디있는지 조건에 맞춰 찾고 거기만 재귀를 돌린다(좌측상단부터 시계방향으로 1,2,3,4사분면)
	private static void cut(int r, int c, int size) {

		if(r == targetR && c == targetC) {
			System.out.println(num);
			return;
		}

		int half = size/2;
		int tmp = (int)Math.pow(half,2);

		//targetR, targetC가 1사분면
		if(targetR < r+half && targetC < c+half) {
			num += 0;
			cut(r, c, half);		//0 0 4
			
		} else if(targetR < r+half && targetC >= c+half) {	//2사분면
			num += ((int) Math.pow(half, 2));
			cut(r, c + half, half);
			
		} else if(targetR >= r + half && targetC < c+half) {	//3사분면
			num += ((int)Math.pow(half,2)*2);    //12+2
			cut(r + half, c, half);          //3,2 1
			
		} else {	//4사분면
			num += (int)Math.pow(half,2)*3;			//12
			cut(r +  half, c + half, half);		//2 2 2
		}
	}

		

}
