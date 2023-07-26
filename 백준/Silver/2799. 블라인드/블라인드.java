import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] ans = new int[5];
        while(M-->0){
            br.readLine(); // 첫줄 넘기기
            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();
            String line4 = br.readLine();


            for(int i = 0 ; i < N; i++){
                int num = 0;
                if(line1.charAt(5*i+1) == '*') num++;
                if(line2.charAt(5*i+1) == '*') num++;
                if(line3.charAt(5*i+1) == '*') num++;
                if(line4.charAt(5*i+1) == '*') num++;
                ans[num]++;
            }
        }
        br.readLine(); // 마지막 줄 빼기
        StringBuilder sb = new StringBuilder();
        for(int i : ans) sb.append(i).append(" ");
        System.out.print(sb);
        br.close();
    }
}