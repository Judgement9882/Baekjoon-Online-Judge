import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[]  dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] board1, board2;
    static boolean[][] vis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board1 = new int[N][M];
        board2 = new int[N][M];
        vis = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++) board1[i][j] = temp.charAt(j) - 'A';
        }

        for(int i = 0 ; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++) board2[i][j] = temp.charAt(j) - 'A';
        }

        System.out.println(check()?"YES":"NO");
        br.close();
    }

    static boolean check(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!vis[i][j]){
                    int origin = board1[i][j];
                    int other = board2[i][j];

                    // 큐에 넣고 bfs 진행, 다른색이 나올경우 false 리턴
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;

                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if(out(nx, ny) || vis[nx][ny]) continue;
                            if(board1[nx][ny] != origin) continue;

                            // 색이 다르면
                            if(board2[nx][ny] != other) return false;

                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    static boolean out(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}