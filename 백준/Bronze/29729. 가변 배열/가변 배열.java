import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int rep = N+M;
        int ans = S;
        int cur = 0;
        while(rep-->0){
            int temp = Integer.parseInt(br.readLine());
            if(temp==1) cur++;
            else cur--;

            if(cur>ans){
                ans *= 2;
            }
        }
        System.out.print(ans);
        br.close();
    }
}