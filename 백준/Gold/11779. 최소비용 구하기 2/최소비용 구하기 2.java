import java.io.*;
import java.util.*;
public class Main {
	
	static int N, M, start, end, ans;
	static int [] dist, prev;
	static boolean[] v;
	static List<int[]>[] g;
	static PriorityQueue<int[]> pq;
	static final int INF = Integer.MAX_VALUE/2;
	
	static void findVertex() {
		ans = 0;
		ArrayDeque<Integer> s = new ArrayDeque<>();
		s.push(end); // 마지막부터 역으로 찾아가기
		while(prev[end] != 0) { // root 까지 찾기
			ans++;
			s.push(prev[end]);
			 end = prev[end];
		}
		System.out.println(ans+1);
		while(!s.isEmpty()) {
			int cur = s.pop();
			System.out.print(cur + " ");
		}
	}
	
	static void dijkstra() {
		pq = new PriorityQueue<>((o1, o2)->{
			return Integer.compare(o1[1], o2[1]);
		});
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			if(v[minVertex]) continue;
			v[minVertex] = true;
			if(min > dist[minVertex]) continue;
			for(int[] i : g[minVertex]) {
				if( dist[i[0]] > min + i[1]) {
					dist[i[0]] = min + i[1];
					prev[i[0]] = minVertex; // 이전 마을 갱신
					pq.offer(new int[] {i[0], dist[i[0]] });
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		g = new List[N+1];
		dist = new int[N+1];
		prev = new int[N+1];
		v = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
			dist[i] = INF;
		}
		for(int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int wei  = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, wei});
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end   = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(dist[end]); 
		findVertex();
		
		br.close();
	}
}