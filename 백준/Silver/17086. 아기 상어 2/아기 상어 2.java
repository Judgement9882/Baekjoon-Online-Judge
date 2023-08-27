import java.io.*;
import java.util.*;
class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1,1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] board = new int[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)q.offer(new int[]{i, j});
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0 ; dir < 8; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(board[nx][ny] > 0) continue;
                board[nx][ny] = board[x][y]+1;
                ans = Math.max(ans, board[nx][ny]);
                q.offer(new int[]{nx, ny});
            }
        }
        System.out.print(ans-1);
        br.close();
    }
}