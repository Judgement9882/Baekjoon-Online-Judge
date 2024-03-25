import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ans = Math.max(ans, Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}