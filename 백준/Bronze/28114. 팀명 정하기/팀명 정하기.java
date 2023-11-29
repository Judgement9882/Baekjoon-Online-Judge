import java.io.*;
import java.util.*;
public class Main {
    static class Person{
        int num;
        int year;
        String name;
        Person(int num, int year, String name){
            this.num = num;
            this.year = year;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 3;
        ArrayList<Person> first = new ArrayList<>();
        ArrayList<Person> second = new ArrayList<>();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Person temp = new Person(num, year%100, name);
            first.add(temp);
            second.add(temp);
        }

        Collections.sort(first, (o1, o2)->{
           return Integer.compare(o1.year, o2.year);
        });

        Collections.sort(second, (o1, o2)->{
            return -Integer.compare(o1.num, o2.num);
        });

        for(int i = 0; i < 3; i++){
            sb.append(first.get(i).year);
        }
        sb.append("\n");
        for(int i = 0; i < 3; i++){
            sb.append(second.get(i).name.charAt(0));
        }
        System.out.println(sb);
        br.close();
    }
}