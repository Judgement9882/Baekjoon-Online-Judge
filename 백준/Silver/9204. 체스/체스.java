import java.awt.datatransfer.Clipboard;
import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {-1, -1, 1, 1}, dy = {-1, 1, 1, -1};
    static HashMap<Integer, Integer> xToBoard = new HashMap<>();
    static HashMap<Character, Integer> yToBoard = new HashMap<>();
    static HashMap<Integer, Integer> boardToX = new HashMap<>();
    static HashMap<Integer, Character> boardToY = new HashMap<>();
    static class Jump{
        int x;
        int y;
        int dist;
        String route = "";

        Jump(int x, int y, int dist, String route){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.route = route;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char numToAlpha[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        for(int i = 8; i >= 1; i--){
            xToBoard.put(i, 8-i);
            boardToX.put(8-i, i);
            yToBoard.put(numToAlpha[8-i], 8-i);
            boardToY.put(8-i, numToAlpha[8-i]);
        }

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean [][] vis = new boolean[8][8];
            // start x,y , end x,y
            char        sy = st.nextToken().charAt(0);
            int         sx = Integer.parseInt(st.nextToken());
            char        ey = st.nextToken().charAt(0);
            int         ex = Integer.parseInt(st.nextToken());

            // board sx, sy, ex, ey
            int bsx = xToBoard.get(sx);
            int bsy = yToBoard.get(sy);
            int bex = xToBoard.get(ex);
            int bey = yToBoard.get(ey);

            // 짝-짝, 홀-홀 = 흰색
            // 홀-짝, 짝-홀 = 검은색
            if(( (bsx%2) ^ (bsy%2) ) == ( (bex%2) ^ (bey%2) )){
                if(bsx == bex && bsy == bey){
                    sb.append(0).append(" ").append(makeString(bsx, bsy));
                    continue;
                }

                ArrayDeque<Jump> q = new ArrayDeque<>();
                q.offer(new Jump(bsx, bsy, 0, makeString(bsx, bsy)));
                vis[bsx][bsy] = true;

                end : while(!q.isEmpty()){
                    Jump cur = q.poll();
                    for(int len = 1; len <= 7; len++){
                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur.x + dx[dir]*len;
                            int ny = cur.y + dy[dir]*len;
                            if(checkOut(nx, ny) || vis[nx][ny]) continue;
                            if(nx == bex && ny == bey) {
                                sb.append(cur.dist+1).append(" ").append(cur.route).append(makeString(nx, ny)).append("\n");
                                break end;
                            }
                            q.offer(new Jump(nx, ny, cur.dist+1, cur.route+makeString(nx, ny)));
                            vis[nx][ny] = true;

                        }
                    }
                }
            }
            else sb.append("Impossible\n");
        }
        System.out.println(sb);
        br.close();
    }

    static String makeString(int x, int y){
        StringBuilder sb = new StringBuilder();
        sb.append(boardToY.get(y)).append(" ").append(boardToX.get(x)).append(" ");
        return sb.toString();
    }

    static boolean checkOut(int x, int y){
        return x < 0 || x >= 8 || y < 0 || y >= 8;
    }
}