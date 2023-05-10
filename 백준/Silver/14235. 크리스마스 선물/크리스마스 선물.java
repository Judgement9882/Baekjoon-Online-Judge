import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> {
			return -Integer.compare(o1,  o2);
		});
			
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if(order == 0) {
				if(pq.size()>0) sb.append(pq.poll()).append("\n");
				else sb.append("-1\n");
			}else {
				while(order-->0) {
					int temp = Integer.parseInt(st.nextToken());
					pq.offer(temp);
				}
			}
		}
		System.out.println(sb);

		br.close(); 
	}
}