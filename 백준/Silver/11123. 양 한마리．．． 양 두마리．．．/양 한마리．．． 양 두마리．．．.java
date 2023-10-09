import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            char board[][] = new char[R][C];
            for (int i = 0; i < R; i++) {
                String temp = br.readLine();
                for (int j = 0; j < C; j++) {
                    board[i][j] = temp.charAt(j);
                }
            }

            int ans = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == '#') {
                        ans++;
                        // bfs
                        ArrayDeque<int[]> q = new ArrayDeque<>();
                        board[i][j] = '.';
                        q.offer(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int cur[] = q.poll();
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = dx[dir] + cur[0];
                                int ny = dy[dir] + cur[1];

                                // 범위
                                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                                if (board[nx][ny] == '.') continue;

                                board[nx][ny] = '.';
                                q.offer(new int[]{nx, ny});
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