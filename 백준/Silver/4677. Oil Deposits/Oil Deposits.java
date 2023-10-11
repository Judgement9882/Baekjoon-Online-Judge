import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            char board [][] = new char[N][M];
            for(int i = 0; i < N; i++){
                String temp = br.readLine();
                for(int j = 0; j < M; j++){
                    board[i][j] = temp.charAt(j);
                }
            }

            int ans = 0;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(board[i][j]=='@'){
                        ans++;
                        board[i][j] = '.';
                        q.offer(new int[] {i, j});
                        while(!q.isEmpty()){
                            int cur[] = q.poll();
                            for(int dir = 0 ; dir < 8; dir++){
                                int nx = dx[dir] + cur[0];
                                int ny = dy[dir] + cur[1];
                                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                                if(board[nx][ny] != '@') continue;
                                board[nx][ny] = '.';
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}