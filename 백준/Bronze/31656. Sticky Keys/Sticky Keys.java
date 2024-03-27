import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        char temp = str.charAt(0);
        sb.append(temp);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == temp) continue;
            sb.append(str.charAt(i));
            temp = str.charAt(i);
        }
        System.out.println(sb);
        br.close();
    }
}