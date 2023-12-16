import java.io.*;
import java.util.*;
public class Main {
    static int N, M, sheep, wolf;
    static int[]  dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] board;
    static boolean[][] vis;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        vis = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(sheep).append(" ").append(wolf);
        System.out.println(sb);
        br.close();
    }

    static void bfs(){
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(!vis[i][j] && board[i][j] != '#'){
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;

                    int o = 0; // sheep
                    int v = 0; // wolf

                    if(board[i][j] == 'v') v++;
                    else if (board[i][j] == 'o') o++;

                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if(out(nx, ny) || vis[nx][ny]) continue;
                            if(board[nx][ny] == '#') continue;
                            if(board[nx][ny] == 'v') v++;
                            else if (board[nx][ny] == 'o') o++;
                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                        }
                    }

                    // check
                    if(o > v) sheep += o;
                    else wolf += v;
                }
            }
        }
    }

    static boolean out(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}