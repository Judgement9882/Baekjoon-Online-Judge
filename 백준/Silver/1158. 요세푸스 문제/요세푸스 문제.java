import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		sb.append('<');
		while(!q.isEmpty()) {
			for(int i = 0; i < K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll());
			if(!q.isEmpty()) sb.append(", ");
		}
		sb.append('>');
		System.out.println(sb);
	}
}
