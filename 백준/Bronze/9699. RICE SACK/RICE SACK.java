import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int t = 1; t <= N; t++){
            int ans = 0;
            int five = 5;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(five-->0){
                int temp = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, temp);
            }
            sb.append("Case #").append(t).append(": ").append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}