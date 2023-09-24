import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int board[][] = new int[N][M];
        for(int i = 0 ; i < N; i++){
            String temp = br.readLine();
            for(int j = 0 ; j < M ; j++){
                if(temp.charAt(j) == '0'){
                    if(j >= 1){
                        board[i][j] = board[i][j-1]+1;
                    }
                    else{
                        board[i][j] = 1;
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] >= K) ans++;
            }
        }
        System.out.print(ans);
        br.close();
    }
}