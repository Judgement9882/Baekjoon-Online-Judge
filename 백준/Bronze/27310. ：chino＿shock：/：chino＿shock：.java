import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		
		int ans = 0;
		for(int i = 0; i < N.length(); i++) {
			char ch = N.charAt(i);
			if (ch == ':') ans += 1;
			if (ch == '_') ans += 5;
		}
		System.out.println(N.length()+ans);
	}
}
