package solution;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ27889_특별한학교이름 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        HashMap<String, String> school = new HashMap<>();
        school.put("NLCS", "North London Collegiate School");
        school.put("BHA", "Branksome Hall Asia");
        school.put("KIS", "Korea International School");
        school.put("SJA", "St. Johnsbury Academy");
        System.out.println(school.get(input));
    }
}
