import java.io.*;
import java.util.*;
public class Main {
    static int[][] doro;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        doro = new int[N+1][M+1];
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 공사중인 도로 등록
            checkConstruct(a, b, c, d);
        }

        long[][] board = new long[N+1][M+1];
        board[0][0] = 1;
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(i==0 && j==0) continue;
                if(j>0 && (doro[i][j] & 1<<1) == 0){
                    board[i][j] += board[i][j-1];
                }
                if(i>0 && (doro[i][j] & 1<<2) == 0){
                    board[i][j] += board[i-1][j];
                }
            }
        }

//        for(int i = 0; i <= N; i++){
//            for(int j = 0 ; j <= M; j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(board[N][M]);
        br.close();
    }

    /*
         왼쪽 : 1<<1
         위쪽 : 1<<2
     */
    static void checkConstruct(int a, int b, int c, int d){
        if(a==c){
            if(b<d){
                if( (doro[c][d] & (1<<1)) == 0) doro[c][d] += (1<<1);
            }
            else{
                if( (doro[a][b] & (1<<1)) == 0) doro[a][b] += (1<<1);
            }
        }else{
            if(a<c){
                if( (doro[c][d] & (1<<2)) == 0) doro[c][d] += (1<<2);
            }
            else{
                if( (doro[a][b] & (1<<2)) == 0) doro[a][b] += (1<<2);
            }
        }
    }
}