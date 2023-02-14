/*
 * BOJ1150. 좌표 정렬하기
 * 이차원 배열을 정렬하기
 * 방법1. 람다식 사용하기
 * 방법2. Comparator 오버라이드하기 -> 전에 공부했던것 찾아보기
 */

package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;



class Pos implements Comparator<Pos>{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compare(Pos o1, Pos o2) {
		// TODO Auto-generated method stub
		if(o1.x > o2.x) {
			Pos tmp = o1;
			o1 = o2;
			o2 = tmp;
			
		} else if(o1.x == o2.x) {
			if(o1.y > o2.y) {
				Pos tmp = o1;
				o1 = o2;
				o2 = tmp;
			}
		}
		
		return 0;
	}
	
	

}

public class BOJ1150_좌표정렬 {
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		Pos[] pos = new Pos[N];	//좌표 배열 생성
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			//System.out.println(Arrays.toString(pos));
		}
		
		//람다식을 사용해  Arrays.sort()를 확장할 수 있어야 한다
		
		for (int i = 0; i < N-1; i++) {
			pos[i].compare(pos[i], pos[i+1]);
		}
		
		
		
		for (int i = 0; i < N; i++) {
			bw.append(pos[i].x + " " + pos[i].y + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
