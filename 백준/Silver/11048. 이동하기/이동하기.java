import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int board[][] = new int[N][M];
        int dp[][] = new int[N][M];
        for(int i = 0; i < N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
              board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = board[0][0];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ; j++){
                int num = 0;
                if(i-1 >= 0){
                    // 대각선
                    if(j-1 >= 0){
                        num = Math.max(num, dp[i-1][j-1]);
                    }
                    // 위
                    num = Math.max(num, dp[i-1][j]);
                }
                if(j-1 >= 0){
                    // 왼쪽
                    num = Math.max(num, dp[i][j-1]);
                }

                dp[i][j] = board[i][j] + num;
            }
        }
        System.out.print(dp[N-1][M-1]);

        br.close();
    }
}