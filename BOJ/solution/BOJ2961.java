/*
 * BOJ2961. 도영이가 만든 맛있는 음식
 * 빼먹은 조건: 공집합 제외 조건 -> 플래그 하나 생성
 * 
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Flavor {
	int s;
	int b;
	public Flavor(int s, int b) {
		this.s = s;
		this.b = b;
	}
	@Override
	public String toString() {
		return "Flavor [s=" + s + ", b=" + b + "]";
	}
}

public class BOJ2961 {

	static int N, Ans;
	static int totalS, totalB;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		Flavor[] flavors = new Flavor[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			flavors[i] = new Flavor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		//부분집합을 전부 구한다.
		totalS = 1;
		totalB = 0;
		Ans = Integer.MAX_VALUE;
		powerSet(flavors, new boolean[N], 0);
		System.out.println(Ans);

		
	}
	/*
	 * flavors : 원본 배열
	 * sel: 선택 여부
	 * idx: 원본 배열 인덱스
	 */
	private static void powerSet(Flavor[] flavors, boolean[] sel, int idx) {
		
		//basis part
		boolean empty_set; //공집합 제외 flag
		if(idx == flavors.length) {
			empty_set = false;

			
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					//System.out.print(flavors[i] + " ");
					//신맛과 쓴맛을 각각 계산
					
					totalS *= flavors[i].s;
					totalB += flavors[i].b;
					empty_set = true;
					
				}
			}
			//System.out.println();
			//여기서!! 둘의 차를 구한다. 그리고 출력값 갱신
			if(empty_set) {
				Ans = Math.min(Ans, Math.abs(totalS-totalB));
				//신맛, 쓴맛의 계산값들을 초기화
				totalB = 0;
				totalS = 1;
			}
			return;
		}
		
		
		//inductive part
		//포함한 경우
		sel[idx] = true;
		powerSet(flavors, sel, idx+1);
		//미포함한 경우
		sel[idx] = false;
		powerSet(flavors, sel, idx+1);
	}
	
	
	

}
