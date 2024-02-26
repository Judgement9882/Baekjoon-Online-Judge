import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] node = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            node[i] = new ArrayList<>();
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }

        // 오름차순을 위한 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(node[i]);
        }

        long [] vis = new long[N+1];
        int order = 1;
        long [] depth = new long[N+1];
        for(int i = 1; i <= N; i++)depth[i] = -1;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {R, 1});
        vis[R] = order++;
        depth[R] = 0;

        while(!q.isEmpty()){
            int []cur = q.poll();
            for(int num : node[cur[0]]){
                if(vis[num] == 0){
                    q.offer(new int[] {num, cur[1]+1});
                    vis[num] = order++;
                    depth[num] = cur[1];
                }
            }
        }
        long ans = 0;
        for(int i = 1; i <= N; i++){
            ans += depth[i] * vis[i];
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}