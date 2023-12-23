import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(N-->0){
            if(x%2==0) x=(x/2)^6;
            else x=(x*2)^6;
        }
        sb.append(x);
        System.out.println(sb);
        br.close();
    }
}