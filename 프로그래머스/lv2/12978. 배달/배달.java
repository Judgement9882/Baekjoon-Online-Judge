import java.util.*;
class Solution {

    public class Road{
        int to;
        int dist;
        public Road(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    public int solution(int N, int[][] road, int K) {
        
        final int INF = Integer.MAX_VALUE/2;
        ArrayList<Road> g[] = new ArrayList[N+1];
        int dist[] = new int[N+1];
        for(int i = 0; i <= N; i++) {
            g[i] = new ArrayList<>();
            dist[i] = INF;
        }
        
        boolean v[] = new boolean[N+1];
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int d = road[i][2];

            g[start].add(new Road(end, d));
            g[end].add(new Road(start, d));
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[1] = 0;
        q.offer(new int[] {1, 0});
        while(!q.isEmpty()){
            int cur[] = q.poll();
            // v[cur[0]] = true;
            for(Road r : g[cur[0]]){ // 방문한 칸과 연결된 길 체크
                if(cur[1] + r.dist < dist[r.to]){ // 새로운 경로가 기존 경로보다 짧다면
                    dist[r.to] = cur[1] + r.dist;
                    // if(!v[r.to] && dist[r.to] <= K){ // 체크하지 않은 마을이라면 경로 체크
                    if(dist[r.to] <= K){ // 체크하지 않은 마을이라면 경로 체크
                        q.offer(new int[]{r.to, dist[r.to]});
                    }
                }
            }
        }
        int answer = 0;
        for(int d : dist){
            if(d <= K) answer++;
        }
        return answer;
    }
}