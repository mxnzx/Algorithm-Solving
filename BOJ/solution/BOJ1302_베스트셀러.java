package solution;

import java.util.*;
import java.io.*;

public class BOJ1302_베스트셀러 {

    static class Book implements Comparable<Book> {
        String name;
        int cnt;
        Book(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Book b) {
            if(this.cnt == b.cnt) return this.name.compareTo(b.name);
            return b.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String bookName = br.readLine();
            if(books.containsKey(bookName)) {
                int prev = books.get(bookName);
                books.replace(bookName, prev + 1);
            } else {
                books.put(bookName, 1);
            }
        }
        Book[] bs = new Book[books.size()];
        int idx = 0;
        for(String s : books.keySet()) {
            bs[idx] = new Book(s, books.get(s));
            idx++;
        }
        Arrays.sort(bs);
        System.out.println(bs[0].name);

    }
}
