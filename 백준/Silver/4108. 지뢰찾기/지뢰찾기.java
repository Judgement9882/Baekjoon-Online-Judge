import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {-1, -1, -1, 0, 1, 1, 1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(R==0 && C==0) break;

            char[][] board = new char[R][C];
            char[][] ans = new char[R][C];
            for(int i = 0; i < R; i++){
                String temp = br.readLine();
                for(int j = 0 ; j < C; j++){
                    board[i][j] = temp.charAt(j);
                    if(board[i][j] == '*') ans[i][j] = '*';
                }
            }

            // 갱신
            for(int i = 0 ;i < R; i++){
                for(int j = 0 ; j < C; j++){
                    if(board[i][j] == '.'){
                        int num = 0;
                        for(int dir = 0 ; dir < 8; dir++){
                            int nx = dx[dir] + i;
                            int ny = dy[dir] + j;
                            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                            if(board[nx][ny] == '*') num++;
                        }

                        ans[i][j] = String.valueOf(num).charAt(0);
                    }
                }
            }

            // 출력
            for(int i = 0 ;i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(ans[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}