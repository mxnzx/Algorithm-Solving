
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA2383_점심식사시간2 {
	//arrivalTime을 기준으로 정렬 -> 우선순위큐 사용?
	static class Person implements Comparable<Person>{
		int r,c, arrivalTime;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
	}
	
	static int T, N,cnt, ans;
	static int[][] map;
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		//시뮬은 단계별 출력메소드를 만든다 -> 단계별로 찍어본다: 배열/리스트의 알기 쉽게 데이터를 출력해본다
		
		//사람들이 어떤 계단을 고를지가 문제의 키포인트다
		//계단 1을 선택할지, 2를 선택할지 => 다해봐야 안다 => PowerSet
		//1. 계단 배정은 PowerSet
		//2. 계단별 사람리스트 만들기 -> 맨하탄거리를 이용해서 계단 도착시간 계산
		//3. 사람리스트 도착시간을 빠른순으로 정렬한다
		//4. 시작시간: 첫사람 도착시간
		//매 시간마다 각각의 사람들의 상태를 변화시킨다 -> 맵에 직접 표시?
		//5. 모든 사람에 대해 시간별 처리
		//  5.1 해당사람 도착시간이 time과 일치 -> 도착상태 인사람 - 1분 대기처리
		//  5.2 해당사람이 도착상태의 사람 - 내려가고있는사람<3 (계단내려가는사람 체크) ->
		//  5.3 해당사람이 내려가는 상태 사람: 내려가는 계단의 수도 카운팅 필요
		// 내려가고 있는 사람 수 증가
		//  해당사람이 내려가고있는사람 ( 내려간계단수 == 계단길이 -> 이동완료사람. 내려가고있는사람수를 감소. 완료 사람수 증가 )
		//  													( 내려간 계단수 < 계단 길이 -> 계단수 카운팅)
		// 이미 도착한 상황이면, skip
		//   5.2.2  내려가고 있는 사람 > 3  -> 대기
		// => 계단A 소요시간과 계단B 소요시간을 비교해서 더 큰게 이 상황의 최솟값.
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>();		//사람리스트
			sList = new int[2][];					//계단리스트
			ans = Integer.MAX_VALUE;
			map = new int[N][N];
			for (int i = 0, k=0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) pList.add(new Person(i, j));
					else if(map[i][j] > 1) sList[k++] = new int[] {i, j, map[i][j]};
				}
			}
			cnt = pList.size();
			selected = new int[cnt];		//선택한 계단 인덱스
			//모든 사람에게 계단을 배정한다
			comb(0);
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		

	}
	private static void comb(int k) {
		//사람들(1)이 계단 1,2를 나누어 선택하도록 그룹을 나눈다
		//필요한 작업: 불린배열, 선택배열인덱스
		if(k == cnt) {
			int res = go();
			if(ans > res) ans = res;
			return;
		}
		
		//계단0 선택
		selected[k] = 0;
		comb(k+1);
		//계단1 선택
		selected[k] = 1;
		comb(k+1);

	}
	//선택된 계단에 따라 사람들의 리스트를 만들고 내려가기 처리한 후 소요된 시간 리턴
	private static int go() {
		ArrayList<Person>[] list = new ArrayList[] {new ArrayList<Person>(), new ArrayList<Person>()};
		
		for(int i=0;i<cnt;i++) {
			Person p = pList.get(i);
			int no = selected[i];    //selected[i] = 0 or 1
			p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);	
		}
		int timeA=0, timeB=0;
		if(list[0].size() > 0) {
			timeA = processDown(list[0], sList[0][2]);
		}
		if(list[1].size() > 0) {
			timeB = processDown(list[1], sList[1][2]);
		}
		return timeA>timeB ? timeA : timeB;
		
	}
	//계단을 내려가는 메서드 - 상태변화를 주면서 단계별로 진행하는 방법 - 이렇게 하지 않아도 됨
	//계단에는 3명이 올라서있을 수 있다. 대기하고 있는 사람기준으로 3칸 앞에 있는 사람이 계단을 다 내려간 경우와 계단을 내려가는 중인 경우
	//사람이 계단이동완료한시간 = 입구도착시간 + 1(대기) + 추가대기시간(있을수도 없을수도 -> 나보다 -3 위치에 있는 사람이 계단을 다 내려갔냐 ) + 계단높이
	//추가 대기시간 - 내 -3앞의 사람이 계단을 다 내려간 시간부터 내가 내려갈 수 있다
	
	private static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list);		//계단입구까지 도착시간이 빠른 순으로 정렬한다 ->  각 사람 계단 이동 완료시간을 계산
												//-3 위치 사람  => 계단이동완료시간을 비교
		int size = list.size()+3;
		int[] D = new int[size];	//0,1,2 는 따로처리해주어도 되지만 0으로 넣고 배열크기를 늘린다
		for (int i = 3; i < size; i++) {
			Person p = list.get(i-3);	//리스트는 0부터 봐줘야함
			if(D[i-3] <= p.arrivalTime +1) {
				D[i] = p.arrivalTime+1 +height;
			} else {
				D[i] = D[i-3] + height;
			}
		}
		return D[size-1];
	}

}
