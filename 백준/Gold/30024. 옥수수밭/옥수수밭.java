import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] con;
    static PriorityQueue<Pos> pq;

    static class Pos{
        int val;
        int x;
        int y;
        Pos(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    static ArrayDeque<Integer> deq = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        con = new boolean[N+1][M+1];
        pq = new PriorityQueue<>((o1, o2)->{
            return -Integer.compare(o1.val, o2.val);
        });
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= M; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                // 수확 가능
                if(i==1 || i == N || j == 1 || j == M) {
                    con[i][j] = true;
                    pq.offer(new Pos(num, i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // K번 진행
        int K = Integer.parseInt(br.readLine());
        while(K-->0){
            while(!pq.isEmpty()) {
                Pos temp = pq.poll();
                // 가능한지 확인
                if (con[temp.x][temp.y] && board[temp.x][temp.y] > 0) {
                    // 출력
                    sb.append(temp.x).append(" ").append(temp.y).append("\n");

                    // 가능 재배 장소 갱신
                    updateCon(temp.x, temp.y);

                    // 사용한 칸으로 표시
                    board[temp.x][temp.y] = 0;
                    break;
                }
            }
        }

        System.out.print(sb);
        br.close();
    }

    static void updateCon(int x, int y){
        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx <= 0 || nx > N || ny <= 0 || ny > M || board[nx][ny] == 0) continue;
            con[nx][ny] = true;
            pq.offer(new Pos(board[nx][ny], nx, ny));
        }
    }
}