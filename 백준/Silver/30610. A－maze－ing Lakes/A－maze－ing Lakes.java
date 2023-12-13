import java.io.*;
import java.util.*;
public class Main {
    static int N, M, ans;
    static int[]  dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] vis;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++) board[i][j] = temp.charAt(j) - '0';
        }

        ans = 0;
        list = new ArrayList<>();
        check();
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        for(int temp : list) sb.append(temp).append(" ");
        System.out.println(sb);
        br.close();
    }

    static void check(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!vis[i][j] && board[i][j] == 1){
                    ans++;
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    int cnt = 1;
                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if(out(nx, ny) || board[nx][ny] == 0 || vis[nx][ny]) continue;
                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                            cnt++;
                        }
                    }
                    list.add(cnt);
                }
            }
        }
    }

    static boolean out(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}