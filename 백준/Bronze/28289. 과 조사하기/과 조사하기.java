import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        int [] ans = new int[4];
        while(P-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if(G==1) ans[3]++;
            else if (C == 1 || C == 2) ans[0]++;
            else if (C == 3) ans[1]++;
            else if (C == 4) ans[2]++;
        }
        for(int temp : ans) sb.append(temp).append("\n");
        System.out.println(sb);
        br.close();
    }
}