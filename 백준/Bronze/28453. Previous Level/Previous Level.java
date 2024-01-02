import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(N-->0){
            int level = Integer.parseInt(st.nextToken());
            if(level == 300) sb.append("1 ");
            else if (level >= 275) sb.append("2 ");
            else if (level >= 250) sb.append("3 ");
            else sb.append("4 ");
        }
        System.out.println(sb);
        br.close();
    }
}