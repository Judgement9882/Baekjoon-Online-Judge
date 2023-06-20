import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] g = new ArrayList[N+1];
		for(int i = 0 ;i<= N; i++) g[i] = new ArrayList<>();
		
		int[] cnt = new int[N+1]; // 진입차수의 개수 구하기
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			g[start].add(end);
			cnt[end]++; // 진입차수 개수 증가
		}
		// 우선순위를 담는 pq
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> {
			return Integer.compare(o1, o2);
		}) ;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(cnt[i]==0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll(); 
			sb.append(cur).append(" ");
			for(int end : g[cur]) {
				cnt[end]--;
				// 진입차수가 0이라면 pq에 넣음
				if(cnt[end]==0) pq.offer(end);
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}