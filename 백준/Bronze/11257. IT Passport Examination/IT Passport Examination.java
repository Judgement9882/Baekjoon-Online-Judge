import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int uuid = Integer.parseInt(st.nextToken());
            int score1 = Integer.parseInt(st.nextToken());
            int score2 = Integer.parseInt(st.nextToken());
            int score3 = Integer.parseInt(st.nextToken());

            boolean ans = true;
            if(score1 + score2 + score3 < 55) ans = false;
            if(score1 < 11 || score2 < 8 || score3 < 12) ans = false;
            sb.append(uuid).append(" ").append(score1+score2+score3).append(" ").append(ans?"PASS":"FAIL").append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}