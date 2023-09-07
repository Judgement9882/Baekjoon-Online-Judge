import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int board[][] = new int[H][W];
        for(int i = 0; i < H; i++){
            String temp = br.readLine();
            for(int j = 0; j < W; j++){
                if(temp.charAt(j)=='.') board[i][j] = -1;
            }
        }
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(board[i][j] == 0){
                    int color = 1;
                    while(j + 1 < W && board[i][j+1] == -1){
                        board[i][j+1] = color++;
                        j++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}