import java.io.*;
import java.util.*;
public class Main {
    static int[]  dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double [][] board = new double[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Double R = Double.parseDouble(st.nextToken());
                Double G = Double.parseDouble(st.nextToken());
                Double B = Double.parseDouble(st.nextToken());

                board[i][j] = (R+G+B)/3;
            }
        }

        double T = Double.parseDouble(br.readLine());
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] >= T) board[i][j] = 255;
                else board[i][j] = 0;
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[N][M];
        int ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!vis[i][j] && board[i][j] == 255){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    ans++;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = dx[dir] + cur[0];
                            int ny = dy[dir] + cur[1];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if(vis[nx][ny] || board[nx][ny] == 0) continue;

                            q.offer(new int[] {nx, ny});
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
        }

        System.out.print(ans);
        br.close();
    }
}