import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int ans = 0;
			for(int x = 1; x <= a; x++) {
				for(int y = 1; y <= b; y++) {
					for(int z = 1 ; z <= c; z++) {
						if(x%y==y%z && y%z==z%x) ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}