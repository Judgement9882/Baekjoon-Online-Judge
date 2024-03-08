import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ddoggeA [] = new int[5];
        int ddoggeB [] = new int[5];
        while(N-->0){
            Arrays.fill(ddoggeA, 0);
            Arrays.fill(ddoggeB, 0);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(a-->0) ddoggeA[Integer.parseInt(st.nextToken())]++;

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            while(b-->0) ddoggeB[Integer.parseInt(st.nextToken())]++;

            int i = 5;
            while(--i>0){
                if(ddoggeA[i] > ddoggeB[i]){
                    sb.append("A");
                    break;
                }else if (ddoggeA[i] < ddoggeB[i]){
                    sb.append("B");
                    break;
                }
            }
            if(i==0) sb.append("D");
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}