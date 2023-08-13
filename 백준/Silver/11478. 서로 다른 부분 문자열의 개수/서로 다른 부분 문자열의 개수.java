import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < temp.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(temp.charAt(i));
            set.add(sb.toString());
            for(int j = i+1; j < temp.length(); j++){
                sb.append(temp.charAt(j));
                set.add(sb.toString());
            }
        }
        Character c =temp.charAt(temp.length()-1);
        set.add(c.toString());
        System.out.print(set.size());
        br.close();
    }
}