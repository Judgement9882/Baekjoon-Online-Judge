import java.io.*;
import java.util.*;
public class Main {
    static int N, M, A, B, K, sx, sy, ex, ey, ans;
    static int[]  dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] vis;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken())-1;
        B = Integer.parseInt(st.nextToken())-1;
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new boolean[N][M];
        // 장애물 처리
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            board[x][y] = -1;
        }

        // 시작, 도착
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;

        ans = bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static int bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 1});
        vis[sx][sy] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(out(nx, ny) || vis[nx][ny]) continue;
                if(!obstacle(nx, ny)) continue;
                if(nx == ex && ny == ey) return cur[2];
                q.offer(new int[]{nx, ny, cur[2]+1});
                vis[nx][ny] = true;
            }
        }
        return -1;
    }

    static boolean out(int x, int y) {
//        return x < 0 || x >= N || y < 0 || y >= M;
        return x < 0 || x+A >= N || y < 0 || y+B >= M;
    }

    static boolean obstacle(int x, int y){
        for(int i = 0; i <= A; i++){
            for(int j = 0 ; j <= B; j++){
                // 장애물이면 false 리턴
                if(board[x+i][y+j] == -1) return false;
            }
        }
        return true;
    }
}