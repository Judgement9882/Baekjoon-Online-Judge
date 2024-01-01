import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] fees = new int[N+1];
        int fee = 0;
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String D = st.nextToken();
            int C = Integer.parseInt(st.nextToken());
            fees[i] = C;
            if(D.equals("jinju")) fee = C;
        }
        for(int i = 1; i <= N; i++){
            if(fees[i] > fee) cnt++;
        }

        sb.append(fee).append("\n").append(cnt);
        System.out.println(sb);
        br.close();
    }
}