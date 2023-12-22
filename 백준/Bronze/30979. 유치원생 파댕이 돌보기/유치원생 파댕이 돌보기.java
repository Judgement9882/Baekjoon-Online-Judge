import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cry = 0;
        while(N-->0){
            int num = Integer.parseInt(st.nextToken());
            cry += num;
        }
        if(cry >= T) sb.append("Padaeng_i Happy");
        else sb.append("Padaeng_i Cry");
        System.out.println(sb);
        br.close();
    }
}