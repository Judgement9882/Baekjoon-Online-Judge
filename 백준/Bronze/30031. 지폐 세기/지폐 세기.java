import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            if(len == 136) ans += 1000;
            else if(len == 142) ans += 5000;
            else if(len == 148) ans += 10000;
            else if(len == 154) ans += 50000;
        }
        System.out.print(ans);
        br.close();
    }
}