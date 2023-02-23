import java.io.*;
import java.util.*;
public class Main{
	
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(),  " ");
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd == 0) {
				if(pq.isEmpty()) System.out.println("0");
				else System.out.println(pq.poll());
			}
			else {
				pq.offer(cmd);
			}
		}
		
		br.close();
	}
}
