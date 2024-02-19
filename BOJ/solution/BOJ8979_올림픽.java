package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ8979_올림픽 {

    static class Country {
        int num, gold, silver, bronze, rank;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getBronze() {
            return bronze;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return gold == country.gold && silver == country.silver && bronze == country.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, gold, silver, bronze, rank);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            countries[i] = new Country(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(countries, Comparator.comparing(Country::getGold)
                .thenComparing(Country::getSilver)
                .thenComparing(Country::getBronze)
                .reversed());

        int rankNum = 1;
        countries[0].rank = rankNum;
        for (int i = 1; i < N; i++) {
            //equals 를 실전에서 쓸 수 없다면 ..
            //Country prev = countries[i-1];
            //Country now = countries[i];
            //if(!(prev.gold == now.gold && prev.silver == now.silver && prev.bronze == now.bronze)) rankNum = i+1;
            if(!countries[i-1].equals(countries[i])) rankNum = i+1;
            countries[i].rank = rankNum;
        }

        for (int i = 0; i < N; i++) {
            if(countries[i].num == K) {
                System.out.println(countries[i].rank);
                return;
            }
        }

    }
}
