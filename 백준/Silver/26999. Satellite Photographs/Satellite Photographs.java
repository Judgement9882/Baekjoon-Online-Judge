import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1,0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        char[][] board = new char[H][W];
        boolean [][] vis = new boolean[H][W];
        for(int i = 0 ; i < H; i++){
            String temp = br.readLine();
            for(int j = 0; j < W; j++){
                board[i][j] = temp.charAt(j);
            }
        }
        int ans = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(!vis[i][j] && board[i][j] == '*'){
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    vis[i][j] = true;
                    q.offer(new int[] {i, j});
                    int num = 1;
                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = dx[dir] + cur[0];
                            int ny = dy[dir] + cur[1];
                            if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                            if(board[nx][ny] != '*' || vis[nx][ny]) continue;
                            vis[nx][ny] = true;
                            q.offer(new int[] {nx, ny});
                            num++;
                        }
                    }
                    ans = Math.max(ans, num);
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}