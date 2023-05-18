import java.io.*;
import java.util.*;
public class Main {
	static int[] originLove = {0, 0, 0, 0};
	static int[] newLove;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			ArrayDeque<String> s = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) s.push(st.nextToken());
			sb.append("Case #").append(i).append(": ");
			while(!s.isEmpty()) sb.append(s.pop()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close(); 
	}
}