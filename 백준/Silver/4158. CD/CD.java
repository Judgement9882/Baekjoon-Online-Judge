import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M == 0) break;
			HashSet<Integer> temp = new HashSet<>();
			HashSet<Integer> ans = new HashSet<>();
			while(N-- > 0) {
				int t = Integer.parseInt(br.readLine());
				temp.add(t);
			}
			while(M-- > 0) {
				int t = Integer.parseInt(br.readLine());
				if(temp.contains(t)) ans.add(t);
			}
			
			sb.append(ans.size()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}