import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int basket[] = new int[N+1];
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int x = i; x <= j; x++) {
				basket[x] = k;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(basket[i]).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}