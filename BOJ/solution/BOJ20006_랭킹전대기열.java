package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20006_랭킹전대기열 {
    static class Room {
        int size;
        int lowLevel;
        int highLevel;
        boolean isStarted;
        Map<String, Integer> players;

        public Room(int size, int lowLevel, int highLevel) {
            this.size = size;
            this.lowLevel = lowLevel;
            this.highLevel = highLevel;
            this.players = new HashMap<>();
        }
    }
    static int p, m;
    static List<Room> rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        rooms = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            if(!searchRoom(level, nickname)) {
                createRoom(level, nickname);
            }
        }
        //출력
        StringBuilder sb = new StringBuilder();
        for(Room room : rooms) {
            List<String> keySet = new ArrayList<>(room.players.keySet());
            Collections.sort(keySet);

            sb.append((room.isStarted) ? "Started!" : "Waiting!").append("\n");
            for(String s : keySet) {
                sb.append(room.players.get(s)).append(" ").append(s).append("\n");
            }

        }
        System.out.println(sb);

    }

    private static void createRoom(int level, String nickname) {
        Room room = new Room(m, level-10, level+10);
        room.players.put(nickname, level);
        rooms.add(room);
        if(room.players.size() == m) room.isStarted = true;

    }

    private static boolean searchRoom(int level, String nickname) {
        for(Room room : rooms) {
            if (room.lowLevel <= level && room.highLevel >= level && !room.isStarted) {
                room.players.put(nickname, level);
                if(room.players.size() == m) room.isStarted = true;
                return true;
            }
        }
        return false;
    }
}
