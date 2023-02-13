import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayDeque<String> q = new ArrayDeque<>();
		while(st.hasMoreTokens()) {
			q.offer(st.nextToken());
		}
		String B = br.readLine();
		int cnt = 0;
		while(!q.isEmpty()) {
			String temp = q.poll();
			if(temp.length() < B.length()) continue;
			if(B.equals(temp.substring(0, B.length())) && !B.equals(temp)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
