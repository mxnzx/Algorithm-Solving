package solution;

import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12100_2048 {
    static class Loc {
        int data;
        boolean isAdd;
        Loc(int data) {
            this.data = data;
        }

        Loc(int data, boolean isAdd) {
            this.data = data;
            this.isAdd = isAdd;
        }
    }

    static int N, maxBlockValue;
    static Loc[][] ogMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ogMap = new Loc[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ogMap[i][j] = new Loc(Integer.parseInt(st.nextToken()));
            }
        }
        // 위치에 val, 합친 여부를 갱신하느냐(그때마다 카피맵 필요) < 백트래킹
        // 새로운 맵을 하나 주고 -> 방향따라서 이동 -> 5번 진행
        for (int d = 0; d < 4; d++) {
            dfs(copy(ogMap), d, 0);
        }
        System.out.println(maxBlockValue);
    }

    private static void dfs(Loc[][] map, int dir, int moveCnt) {

        if (moveCnt == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxBlockValue = Math.max(maxBlockValue, map[i][j].data);
                }
            }
            return;
        }

        if (dir == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int now = map[i][j].data;
                    for (int k = i-1; k >= 0; k--) {
                        if(map[k][j].data == 0) {
                            map[k][j].data = now;
                            map[k+1][j].data = 0;
                        } else if(map[k][j].data == now && !map[k][j].isAdd) {
                            map[k][j].data += now;
                            map[k][j].isAdd = true;
                            map[k+1][j].data = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        } else if (dir == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = N-1; j >= 0; j--) {
                    int now = map[i][j].data;
                    for (int k = j+1; k < N; k++) {
                        if(map[i][k].data == 0) {
                            map[i][k].data = now;
                            map[i][k-1].data = 0;
                        } else if(map[i][k].data == now && !map[i][k].isAdd) {
                            map[i][k].data += now;
                            map[i][k].isAdd = true;
                            map[i][k-1].data = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = N-1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    int now = map[i][j].data;
                    for (int k = i+1; k < N; k++) {
                        if(map[k][j].data == 0) {
                            map[k][j].data = now;
                            map[k-1][j].data = 0;
                        } else if(map[k][j].data == now && !map[k][j].isAdd) {
                            map[k][j].data += now;
                            map[k][j].isAdd = true;
                            map[k-1][j].data = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        } else if (dir == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int now = map[i][j].data;
                    for (int k = j-1; k >= 0; k--) {
                        if(map[i][k].data == 0) {
                            map[i][k].data = now;
                            map[i][k+1].data = 0;
                        } else if(map[i][k].data == now && !map[i][k].isAdd) {
                            map[i][k].data += now;
                            map[i][k].isAdd = true;
                            map[i][k+1].data = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        for (int d = 0; d < 4; d++) {
            dfs(copy(map), d, moveCnt + 1);
        }
    }

    private static Loc[][] copy(Loc[][] map) {
        Loc[][] copyMap = new Loc[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = new Loc(map[i][j].data, false);
            }
        }
        return copyMap;
    }
}
