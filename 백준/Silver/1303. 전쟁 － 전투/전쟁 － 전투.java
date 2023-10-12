import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char board[][] = new char[N][M];
        boolean vis[][] = new boolean[N][M];
        for(int i = 0 ;i < N; i++){
            String temp = br.readLine();
            for(int j = 0 ; j < M; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        long W = 0, B = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 방문하지 않았다면
                if(!vis[i][j]){
                    vis[i][j] = true;
                    char color = board[i][j];
                    q.offer(new int[] {i, j});
                    int num = 1;
                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir = 0; dir < 4 ; dir++){
                            int nx = dx[dir] + cur[0];
                            int ny = dy[dir] + cur[1];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if(board[nx][ny] != color || vis[nx][ny]) continue;
                            vis[nx][ny] = true;
                            q.offer(new int[] {nx, ny});
                            num++;
                        }
                    }

                    // N^2
                    if(board[i][j] == 'W') W += num*num;
                    else if(board[i][j] == 'B') B += num*num;
                }
            }
        }
        System.out.print(W + " " + B);
        br.close();
    }
}