import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N+1];
        boolean [] vis = new boolean[N+1];

        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        // S번부터 찾기 시작
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{S, 0});
        vis[S] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int []cur = q.poll();
            if(cur[0] == E) {
                ans = cur[1];
                break;
            }
            // 연결된 곳
            for(int i : list[cur[0]]){
                if(vis[i]) continue;
                q.offer(new int[] {i, cur[1]+1});
                vis[i] = true;
            }
            // +1, -1
            if(cur[0]-1>=1 && !vis[cur[0]-1]){
                q.offer(new int[] {cur[0]-1, cur[1]+1});
                vis[cur[0]-1] = true;
            }

            if(cur[0]+1<=N && !vis[cur[0]+1]){
                q.offer(new int[] {cur[0]+1, cur[1]+1});
                vis[cur[0]+1] = true;
            }
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}