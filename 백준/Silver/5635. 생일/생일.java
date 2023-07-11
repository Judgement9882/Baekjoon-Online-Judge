import java.io.*;
import java.util.*;
public class Main {
    static class Person{
        String name;
        int day;
        int month;
        int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> p = new ArrayList<>();
        int rep = n;
        while(rep-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p.add(new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(p, (o1, o2) -> {
            int r = -Integer.compare(o1.year, o2.year);
            if(r!=0) return r;
            r = -Integer.compare(o1.month, o2.month);
            if(r!=0) return r;
            return -Integer.compare(o1.day, o2.day);
        });
        StringBuilder sb = new StringBuilder();
        sb.append(p.get(0).name).append("\n").append(p.get(n-1).name);
        System.out.println(sb);
        br.close();
    }
}