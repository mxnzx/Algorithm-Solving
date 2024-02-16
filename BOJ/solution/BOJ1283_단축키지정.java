package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1283_단축키지정 {
    static Map<Character, Integer> alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        alphabet = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            boolean canFirstAlphabet = false;

            StringBuilder tmpWord = new StringBuilder();
            while(st.hasMoreTokens()) {
                String word = st.nextToken();

                if(canFirstAlphabet) {
                    tmpWord.append(word).append(" ");
                    continue;
                }

                char c = word.charAt(0);
                char upperC = upper(c);

                if(alphabet.containsKey(upperC)) {
                    tmpWord.append(word).append(" ");
                    continue;
                }

                alphabet.put(upperC, 1);
                canFirstAlphabet = true;
                tmpWord.append("[").append(c).append("]");
                tmpWord.append(word.substring(1)).append(" ");
            }

            if(!canFirstAlphabet) {
                for (int j = 0; j < input.length(); j++) {
                    char c = input.charAt(j);
                    if(c == ' ') continue;
                    char upperC = upper(c);
                    if(!alphabet.containsKey(upperC)) {
                        alphabet.put(upperC, 1);
                        tmpWord.insert(j, "[");
                        tmpWord.insert(j+2, "]");
                        break;
                    }
                }
            }
            sb.append(tmpWord).append("\n");
        }
        System.out.println(sb);
    }
    public static char upper(char c) {
        if(c > 90) c = (char) (c - 32);
        return c;
    }
}
