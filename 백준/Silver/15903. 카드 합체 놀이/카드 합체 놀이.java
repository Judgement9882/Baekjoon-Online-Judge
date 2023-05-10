import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2)-> {
			return Long.compare(o1,  o2);
		});
		st = new StringTokenizer(br.readLine());		
		for(int i = 0 ; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		for(int i = 0; i < M; i++) {
			long a = pq.poll();
			long b = pq.poll();
			pq.offer(a+b);
			pq.offer(a+b);
		}
		long ans = 0;
		while(!pq.isEmpty()) {
			ans+=pq.poll();
		}
		System.out.println(ans);
		br.close(); 
	}
}