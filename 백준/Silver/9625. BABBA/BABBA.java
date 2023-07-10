import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        if(K==1) System.out.print("0 1");
        else {
            int dp[] = new int[K + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= K; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[K-1] + " " + dp[K]);
        }
        br.close();
    }
}