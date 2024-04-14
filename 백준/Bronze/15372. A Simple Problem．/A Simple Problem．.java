import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            long N = Integer.parseInt(br.readLine());
            sb.append(N*N).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}