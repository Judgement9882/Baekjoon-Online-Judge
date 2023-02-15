import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
			Integer.compare(o1[0], o2[0]) == 0?
			Integer.compare(o1[1], o2[1]):
			Integer.compare(o1[0], o2[0]) 
		
		);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0) {
				// 비었을 경우 0을 출력
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				
				sb.append(pq.poll()[1]).append("\n");
			}
			
			// 추가
			else {
				pq.offer(new int[] {Math.abs(temp), temp});
			}
		}
		
		
		System.out.println(sb);
		br.close();
	}
}
