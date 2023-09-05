import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        int row = 0, col = 0;
        if(N!=1){
            for(int i= 0; i < N; i++){
                String temp = br.readLine();
                char prev = temp.charAt(0);
                board[i][0] = temp.charAt(0);
                boolean rowcheck = false;
                for(int j =1; j < N; j++){
                    if(prev == 'X') rowcheck = false;
                    board[i][j] = temp.charAt(j);
                    if(!rowcheck){
                        if(prev == '.' && prev == board[i][j]) {
                            rowcheck = true;
                            row++;
                        }

                    }
                    prev = board[i][j];
                }


            }

            for(int i= 0; i < N; i++){
                char prev = board[0][i];
                boolean colcheck = false;
                for(int j =1; j < N; j++){
                    if(prev == 'X') colcheck = false;
                    if(!colcheck){
                        if(prev == '.' && prev == board[j][i]) {
                            colcheck = true;
                            col++;
                        }

                    }
                    prev = board[j][i];
                }


            }
        }
        else{
            for(int i = 0 ; i < N; i++) br.readLine();
        }
        System.out.print(row + " " + col);
        br.close();
    }
}