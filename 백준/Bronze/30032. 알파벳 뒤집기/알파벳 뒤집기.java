import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        char board[][] = new char[N][N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 상하
        if(D==1){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(board[i][j] == 'd') board[i][j] = 'q';
                    else if(board[i][j] == 'b') board[i][j] = 'p';
                    else if(board[i][j] == 'q') board[i][j] = 'd';
                    else if(board[i][j] == 'p') board[i][j] = 'b';
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        else{ // 좌우
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(board[i][j] == 'd') board[i][j] = 'b';
                    else if(board[i][j] == 'b') board[i][j] = 'd';
                    else if(board[i][j] == 'q') board[i][j] = 'p';
                    else if(board[i][j] == 'p') board[i][j] = 'q';
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}