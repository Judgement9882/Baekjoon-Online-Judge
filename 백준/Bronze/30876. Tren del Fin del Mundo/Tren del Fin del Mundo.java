import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] ans = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        ans[0] = x; ans[1] = y;
        while(N-->1){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(y < ans[1]) {
                ans[1] = y;
                ans[0] = x;
            }
        }

        sb.append(ans[0]).append(" ").append(ans[1]);
        System.out.println(sb);
        br.close();
    }
}