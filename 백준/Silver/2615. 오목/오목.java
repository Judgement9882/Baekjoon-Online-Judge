import java.io.*;
import java.util.*;
public class Main {
    static int N = 19;
    static int [][] board;
    // 가로
    static int []dx1 = {0, 0};
    static int []dy1 = {-1, 1};
    // 세로
    static int []dx2 = {1, -1};
    static int []dy2 = {0, 0};
    // 우상
    static int []dx3 = {-1, 1};
    static int []dy3 = {1, -1};
    // 4 우하
    static int []dx4 = {1, -1};
    static int []dy4 = {1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        // 바둑판 저장 배열
        board = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean gameEnd = false;
        end : for(int j = 1; j <= N; j++){
            for(int i =1 ; i <= N; i++){
                if(board[i][j] != 0 && checkOmok(board[i][j], i, j)){
                    sb.append(board[i][j]).append("\n").append(i).append(" ").append(j);
                    gameEnd = true;
                    break end;
                }
            }
        }
        if(!gameEnd) sb.append(0);

        System.out.println(sb);
        br.close();
    }

    static boolean checkOmok(int color, int x, int y){
        if(checkFive(dx1, dy1, x, y, color) == 5) return true;
        if(checkFive(dx2, dy2, x, y, color) == 5) return true;
        if(checkFive(dx3, dy3, x, y, color) == 5) return true;
        if(checkFive(dx4, dy4, x, y, color) == 5) return true;
        return false;
    }

    static int checkFive(int []dx, int []dy, int x, int y, int color){
        int num = 1;
        for(int i = 0; i < 2; i++){
            int nx = x;
            int ny = y;
            while(true){
                nx += dx[i];
                ny += dy[i];
                if(checkOut(nx, ny)) break;
                if(board[nx][ny] != color) break;
                num++;
            }
        }
        return num;
    }

    static boolean checkOut(int x, int y){
        return x <= 0 || x > N || y <= 0 || y > N;
    }
}