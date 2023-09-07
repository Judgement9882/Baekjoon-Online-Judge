import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int acc[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==1) acc[i] = arr[i];
			else acc[i] = acc[i-1]+arr[i];
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(acc[j] - acc[i-1]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}