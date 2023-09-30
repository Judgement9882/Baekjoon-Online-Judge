import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 1, 0, -1}, dy = {1, 0 ,-1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char board [][] = new char[N][M];
        boolean vis[][] = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0 ; j < M; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        int ans = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(board[i][j] == '.' && !vis[i][j]){
                    vis[i][j] = true;
                    int num = 1;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    while(!q.isEmpty()){
                        int cur [] = q.poll();
                        for(int dir = 0 ; dir< 4 ; dir++){
                            int nx = dx[dir] + cur[0];
                            int ny = dy[dir] + cur[1];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if(board[nx][ny] != '.' || vis[nx][ny]) continue;
                            vis[nx][ny] = true;
                            num++;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                    ans = Math.max(ans, num);
                }
            }
        }
        System.out.print(ans);
        br.close();
    }
}