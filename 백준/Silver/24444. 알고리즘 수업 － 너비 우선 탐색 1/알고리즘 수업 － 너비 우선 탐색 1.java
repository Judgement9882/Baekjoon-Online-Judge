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

        int [] vis = new int[N+1];
        int order = 1;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(R);
        vis[R] = order++;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int num : node[cur]){
                if(vis[num] == 0){
                    q.offer(num);
                    vis[num] = order++;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            sb.append(vis[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}