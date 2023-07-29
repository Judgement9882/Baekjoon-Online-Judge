import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int axis = 501;
        int X = Integer.parseInt(st.nextToken())+axis;
        int Y = Integer.parseInt(st.nextToken())+axis;
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[1002][1002];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())+axis;
            int B = Integer.parseInt(st.nextToken())+axis;
            board[A][B] = -1;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {axis, axis});
        board[axis][axis] = 1;
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
        int ans = 2;
        end : while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = dx[dir] + cur[0];
                int ny = dy[dir] + cur[1];
//                System.out.println("nx :"+(nx) + " " + (ny));
                if(nx < 0 || nx >= 1002 || ny < 0 || ny >= 1002) continue;
                if(nx == X && ny == Y) {
                    ans = board[cur[0]][cur[1]] + 1;
                    break end;
                }
                if(board[nx][ny] != 0) continue; // 웅덩이거나 방문한 곳
                board[nx][ny] = board[cur[0]][cur[1]] + 1;

                // debug

//                System.out.println(board[nx][ny]);
                q.offer(new int[] {nx, ny});
            }
        }
        System.out.print(ans-1); // 최초에 1부터 시작해서.
        br.close();
    }
}