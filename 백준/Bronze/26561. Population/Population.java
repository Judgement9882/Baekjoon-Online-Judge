import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        while(N-->0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            sb.append(p-(t/7)+(t/4)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}