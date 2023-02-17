/*
 * [BOJ]3040. 백설공주난쟁이
 * 놓친 부분: 두 수를 찾아 제외하는 반복문에서 변수 잘못 줌. j가 i부터 되면 자기 자신부터 시작하므로 예외 발생
 */
package solution;

import java.util.Scanner;

public class BOJ3040_백설공주난쟁이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] hat = new int[9];
		
		// 9개 중 7개를 더해서 100을 만들어야함
		// 입력값을 다 더해서 2개를 뺐을 때 100이 되는 수를 찾으면 어떨가
		
		int inputSum = 0;
		for (int i = 0; i < hat.length; i++) {
			hat[i] = sc.nextInt();
			inputSum += hat[i];
		}
		
		int tmp = inputSum - 100; 		
		
		//두 개 더해서  tmp 값이 되는 두 수를 찾아 제외하자
		L:for (int i = 0; i < hat.length; i++) {
			for (int j = i+1; j < hat.length; j++) {
				if((tmp - hat[i]) == hat[j]) {
					//더해서 값이 tmp인 두 수를 찾으면 0으로 만든다
					hat[i] = 0;
					hat[j] = 0;
					break L;
				}
			}

		}
		//값이 0으로 바뀐애들은 넘어가고 나머지 애들이 난쟁이므로 출력한다.
		for (int i = 0; i < hat.length; i++) {
			if(hat[i] == 0) continue;
			System.out.println(hat[i]);
		}
		
	}

}
