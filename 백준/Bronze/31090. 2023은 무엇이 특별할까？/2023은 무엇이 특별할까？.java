import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            int year = Integer.parseInt(br.readLine());
            if((year+1) % (year%100) == 0) sb.append("Good");
            else sb.append("Bye");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}