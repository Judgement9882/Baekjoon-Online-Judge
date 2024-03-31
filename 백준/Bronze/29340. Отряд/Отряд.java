import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String A = br.readLine();
        String B = br.readLine();
        for(int i = 0; i < A.length(); i++){
            int a = A.charAt(i) - '0';
            int b = B.charAt(i) - '0';
            if(a>b) sb.append(a);
            else sb.append(b);
        }
        System.out.println(sb);
        br.close();
    }
}