import java.io.*;
import java.util.*;
public class Main {
	static int N, M, start, end, ans;
	static List<int[]>[] g;
	static int[] dist;
	static List<Integer>[] prev;
	static PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2)->{
		return Integer.compare(o1[1], o2[1]);
	});
	static boolean [][] shortest;
	static final int INF = Integer.MAX_VALUE/2;
	
	static void dijkstra() {
		dist = new int[N];
		for(int i = 0; i < N; i++) dist[i] = INF;
		
		pq.clear();
		dist[start] = 0;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			
			// 더 큰 가중치라면 pass
			if(min > dist[minVertex]) continue;
			
			for(int[] j : g[minVertex]) {
				// 최단 경로 간선이라면 pass
				if(shortest[minVertex][j[0]]) continue;
				
				// 만약 가중치가 같다면 최단 경로를 여러개 갱신
				if(dist[j[0]] == min + j[1]) {
					prev[j[0]].add(minVertex);
				}
				
				// 더 작다면 이전 기록 다 날리고 갱신
				if( dist[j[0]] > min + j[1]) {
					dist[j[0]] = min + j[1];
					prev[j[0]].clear();
					prev[j[0]].add(minVertex);
					pq.offer(new int[] {j[0], dist[j[0]]});
				}
			}
		}
	}
	
	// 끝에서부터 처음까지 올라감
	static void checkPath(int index) {
		if(index == start) return; // 도착
		
		for(int i = 0 ; i < prev[index].size(); i++) {
			int pre = prev[index].get(i);
			if(!shortest[pre][index]) { // false일때
				shortest[pre][index] = true; // 최단 경로 간선 표시
				checkPath(pre);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 1
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0) break;
			
			// 2
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			// 3
			g = new List[N];
			prev = new List[N];
			for(int i = 0 ;i < N; i++) { 
				g[i] = new ArrayList<>();
				prev[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from   = Integer.parseInt(st.nextToken());
				int to     = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				g[from].add(new int[] {to , weight});
			}
			shortest = new boolean[N][N];
			dijkstra(); // 최단 경로들 찾기
			checkPath(end); // 최단 경로들의 간선 표시
			dijkstra(); // 다시 최단경로
			
			sb.append(dist[end]==INF?"-1\n":dist[end]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}