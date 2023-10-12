import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int board[][] = new int[5][5];
        for(int i = 0 ;i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) board[i][j] = -2;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        board[r][c] = 1;

        int ans = 0;
        end : while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int dir = 0; dir < 4 ; dir++){
                int nx = dx[dir] + cur[0];
                int ny = dy[dir] + cur[1];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(board[nx][ny] == -2){
                    ans = board[cur[0]][cur[1]];
                    break end;
                }
                else if (board[nx][ny] == -1) continue;
                else if (board[nx][ny] == 0){
                    q.offer(new int[] {nx, ny});
                    board[nx][ny] = board[cur[0]][cur[1]]+1;
                }
            }
        }
        System.out.print(ans==0?-1:ans);
        br.close();
    }
}