import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String name = br.readLine();
            if(name.contains("S")) sb.append(name);
        }
        System.out.println(sb);
        br.close();
    }
}