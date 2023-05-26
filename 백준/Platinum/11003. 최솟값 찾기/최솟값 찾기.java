import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int A = Integer.parseInt(st.nextToken());

			// 만약 dq의 오른쪽에 있는 수가 새로 들어갈 수보다 크다면 pop
			while(!dq.isEmpty() && (dq.peekLast()[0] >= A)) dq.pollLast();
			
			dq.offerLast(new int[] {A, i});
			
			// 제일 작은수 (왼쪽)의 [1]이 i-L+1 보다 작다면 해당되는 범위가 아니므로 pop
			while(dq.peekFirst()[1] < i-L+1) dq.pollFirst();
			sb.append(dq.peekFirst()[0]).append(" ");
		}
		System.out.println(sb);
		
		
		br.close(); 
	}
}