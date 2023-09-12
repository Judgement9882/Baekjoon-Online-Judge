import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int board[][] = new int[5][5];
        boolean vis[][] = new boolean[5][5];
        for(int i = 0 ; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        end : for(int i = 0 ; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                ans++;
                for(int x = 0; x < 5; x++){
                    for(int y = 0 ; y < 5; y++){
                        if(board[x][y] == num) vis[x][y] = true;
                    }
                }

                // debug
//                System.out.println("Debug");
//                for(int x = 0; x < 5; x++){
//                    for(int y = 0 ; y < 5; y++){
//                        System.out.print(vis[x][y] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("Debug");

                if(bingo(vis) >= 3) {
                    System.out.print(ans);
                    break end;
                }
            }
        }
        br.close();
    }

    static int bingo(boolean[][] vis){
        int res = 0;
        // 가로 체크
        end : for(int i = 0 ; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!vis[i][j]) continue end;
            }
            res++;
        }

        // 세로 체크
        end : for(int i = 0 ; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!vis[j][i]) continue end;
            }
            res++;
        }

        // 대각선 체크
        if(vis[0][0] && vis[1][1] && vis[2][2] && vis[3][3] && vis[4][4]) res++;
        if(vis[4][0] && vis[3][1] && vis[2][2] && vis[1][3] && vis[0][4]) res++;
        return res;
    }
}