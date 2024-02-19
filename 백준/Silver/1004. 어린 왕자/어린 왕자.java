import java.io.*;
import java.util.*;
public class Main {
    static boolean checkIn(int x, int y, int cx, int cy, int r){
        int x2 = Math.abs((x-cx)*(x-cx));
        int y2 = Math.abs((y-cy)*(y-cy));
        return x2 + y2 <= r*r;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            while(N-->0){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                // 1. 출발점 and 도착점을 둘 다 포함 => 의미없음
                if(checkIn(x1, y1, cx, cy, r) && checkIn(x2, y2, cx, cy, r)) continue;
                // 2. 출발점 and 도착점 둘 다 포함x => 의미없음
                if(!checkIn(x1, y1, cx, cy, r) && !checkIn(x2, y2, cx, cy, r)) continue;
                // 그 외
                ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}