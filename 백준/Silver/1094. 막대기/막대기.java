import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		while(N != 0) {
			if(N%2 != 0) ans++;
			N/=2;
		}
		System.out.println(ans);
		br.close();
	}
}