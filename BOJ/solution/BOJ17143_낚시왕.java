//package solution;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BOJ17143_낚시왕 {
//	static class Shark implements Comparable<Shark>{
//		int r,c,s,d,z;
//
//		public Shark(int r, int c, int s, int d, int z) {
//			super();
//			this.r = r;
//			this.c = c;
//			this.s = s;
//			this.d = d;
//			this.z = z;
//		}
//
//		//상어 비교는 크기로
//		@Override
//		public int compareTo(Shark o) {
//			// TODO Auto-generated method stub
//			return Integer.compare(this.z, o.z);
//		}
//	}
//	//               안씀,상,하,좌,우
//	static int[] dr = {0,-1,1,0,0};
//	static int[] dc = {0,0,0,1,-1};
//
//	static int R,C,M,Ans=0,king=0;
//	static Shark[][] map;
//	static ArrayList<Shark> sharks;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine());
//		R = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		//인덱스1,1부터 쓴다
//		map = new Shark[R+1][C+1];
//		//상어 배열
//		sharks = new ArrayList<>();
//
//		//상어정보 입력
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int r = Integer.parseInt(st.nextToken());
//			int c = Integer.parseInt(st.nextToken());
//			sharks.add(new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//			//입력받은 상어를 지도에 표시하기
//			map[r][c] = sharks.get(i);	//상어가 표시되지 않은 애들은 null로 초기화 됨.
//		}
//		print(map);
//
//		//낚시왕이 오른쪽 열에 도착했을때까지 반복
//		do {
//			king++;	//시작할때 1초 증가 -> 한칸이동하고 로직 시작
//			//낚시왕과 같은 열에 있는 상어가 있으면 잡는다. -> 잡으면 Ans++
//			catchShark(king);
//			//System.out.println(king +" " + sharks.size());
//			//상어가 각자 이동한다
//			moveShark();
//			//같은 위치에 상어있는지 확인 - 있으면 값 비교후 크기가 더 작은 애를 상어리스트에서 제외시킴
//
//		} while(king < C);
//
//
//	}
//	//상어가 각자의 속력과 방향으로 이동하는 메서드
//	private static void moveShark() {
//		//남아있는 상어 배열을 돌면서 하나씩 이동하자
//		for(Shark shark : sharks) {
//			//방향알기
//			int dir = shark.d;
//			//이동거리알기
//			int dis = shark.s;
//
//			int nr = shark.r + dr[dir]*dis;
//			int nc = shark.c + dc[dir]*dis;
//
//			//행과 열을 벗어나면 방향 뒤집어서(=  ) 위치 이동 -> 상하좌우 4개 따로 분리한다. 헷갈려죽겠어
//			switch (dir) {
//			case 1:	//상
//				if(nr<=0) {
//					int tmp = dis - shark.r + 1;	//앞으로 더 가야하는 거리
//				}
//
//				break;
//			case 2: //하
//
//				break;
//			case
//			default:
//				break;
//			}
//
//
//		}
//
//	}
//	//상어를 잡는 메서드(같은 열에 상어가 있으면 없앤다.)
//	private static void catchShark(int king) {
//		for (int i = 1; i <= R; i++) {
//			for (int j = 1; j <= C; j++) {
//				//null이 아니면 상어가 있다는 뜻이므로 null로 바꾸고 Ans를 증가
//				if(j == king && map[i][j] != null) {
//					map[i][j] = null;
//					//상어도 상어 배열에서 없애야 함.
//					for (int k = 0; k < sharks.size(); k++) {
//						Shark shark = sharks.get(k);
//						if(shark.r == i && shark.c == j) {
//							sharks.remove(k);
//						}
//					}
//					Ans++;
//				}
//			}
//		}
//	}
//
//	private static void print(Shark[][] map) {
//		for (int i = 1; i <= R; i++) {
//			for (int j = 1; j <= C; j++) {
//				System.out.print(map[i][j] + "\t\t\t\t\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//	}
//
//}
