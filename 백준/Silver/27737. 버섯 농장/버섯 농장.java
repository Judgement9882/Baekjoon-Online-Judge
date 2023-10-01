import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 1, 0, -1}, dy = {1, 0 ,-1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int board [][] = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean can = true;
        int num = M;
        end : for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(board[i][j] == 0){
                    if(num <= 0) {
                        can = false;
                        break end;
                    }
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    board[i][j] = -1; // 농사
                    int area = 1;

                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir = 0;dir < 4 ; dir++){
                            int nx = dx[dir] + cur[0];
                            int ny = dy[dir] + cur[1];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(board[nx][ny] != 0) continue;

                            q.offer(new int[]{nx, ny});
                            board[nx][ny] = -1;
                            area++;
                        }
                    }

                    int minus = area / K;
                    if(area % K != 0) minus++;
                    num -= minus;
                }
            }
        }
        // 버섯포자를 하나라도 사용하고
        if(num==M) can = false;

        System.out.print(can?"POSSIBLE\n"+num:"IMPOSSIBLE");
        br.close();
    }
}