import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long [][] board = new long[N][M];
        final int mod = 1_000_000_007;
        board[0][0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 대각선 위
                if(i > 0 && j > 0) board[i][j] += board[i-1][j-1];
                // 위
                if(i > 0) board[i][j] += board[i-1][j];
                // 왼쪽
                if(j > 0) board[i][j] += board[i][j-1];

                board[i][j] %= mod;
            }
        }
        System.out.print(board[N-1][M-1]);
        br.close();
    }
}