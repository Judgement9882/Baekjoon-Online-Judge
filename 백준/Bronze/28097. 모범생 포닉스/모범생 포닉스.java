import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += Integer.parseInt(st.nextToken());
			if(i!=N-1) ans+= 8;
		}
		int month = 0;
		month = ans / 24;
		ans -= month*24;
		System.out.println(month + " " + ans);
		
		
		br.close();
	}
}