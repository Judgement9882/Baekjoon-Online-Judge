import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> sentence = new HashSet<>();
        sentence.add("Never gonna give you up");
        sentence.add("Never gonna let you down");
        sentence.add("Never gonna run around and desert you");
        sentence.add("Never gonna make you cry");
        sentence.add("Never gonna say goodbye");
        sentence.add("Never gonna tell a lie and hurt you");
        sentence.add("Never gonna stop");
        int N = Integer.parseInt(br.readLine());
        boolean ans = true;
        while(N-->0){
            String temp = br.readLine();
            if(!sentence.contains(temp)) ans = false;
        }
        System.out.println(ans?"No":"Yes");
        br.close();
    }
}