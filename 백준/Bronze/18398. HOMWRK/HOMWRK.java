import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            while(N-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                long A = Integer.parseInt(st.nextToken());
                long B = Integer.parseInt(st.nextToken());
                sb.append(A+B).append(" ").append(A*B).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}