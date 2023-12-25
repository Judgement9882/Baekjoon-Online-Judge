import java.io.*;
import java.util.*;
public class Main {

    static class Place{
        int num;
        int dist;

        Place(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N+1];
        boolean [] vis = new boolean[N+1];
        int[] sameDist = new int[N+1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        PriorityQueue<Place> pq = new PriorityQueue<>((o1, o2)->{
            int r = -Integer.compare(o1.dist, o2.dist);
            if(r==0) return Integer.compare(o1.num, o2.num);
            return r;
        });
        // 1번부터 찾기 시작
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        vis[1] = true;
        while(!q.isEmpty()){
            int []cur = q.poll();
            for(int i : list[cur[0]]){
                if(vis[i]) continue;
                q.offer(new int[] {i, cur[1]+1});
                vis[i] = true;
                pq.offer(new Place(i, cur[1]+1));
                sameDist[cur[1]+1]++;
            }
        }
        Place temp = pq.poll();
        sb.append(temp.num).append(" ").append(temp.dist).append(" ").append(sameDist[temp.dist]);
        System.out.println(sb);
        br.close();
    }
}