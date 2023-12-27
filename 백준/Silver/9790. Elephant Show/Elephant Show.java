import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            char [][] board = new char[N][M];
            boolean [][] vis = new boolean[N][M];

            int sx = 0;
            int sy = 0;

            for(int i = 0 ; i < N; i++){
                String temp = br.readLine();
                for(int j = 0; j < M; j++){
                    board[i][j] = temp.charAt(j);
                    if(board[i][j] == 'A'){
                        sx = i;
                        sy = j;
                    }
                }
            }

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{sx, sy});
            vis[sx][sy] = true;
            int ans = 1;
            while(!q.isEmpty()){
                int []cur = q.poll();
                for(int dir = 0 ; dir < 4; dir++){
                    int nx = dx[dir]+cur[0];
                    int ny = dy[dir]+cur[1];
                    if(checkOut(nx, ny, N, M)) continue;
                    if(vis[nx][ny] || board[nx][ny] != '.') continue;
                    q.offer(new int[] {nx, ny});
                    vis[nx][ny] = true;
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static boolean checkOut(int x, int y, int N, int M){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}