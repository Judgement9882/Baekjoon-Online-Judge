import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 1;
		int a = 1, b = 1, c = 1;
		while(true) {
			if(a==E && b == S && c == M) break;
			a = a%15 + 1;
			b = b%28 + 1;
			c = c%19 + 1;
			ans++;
		}
		sb.append(ans);
		System.out.println(sb);
		br.close();
	}
}