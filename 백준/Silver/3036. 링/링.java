import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ring = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			int gcd_num = gcd(ring, num);
			sb.append(ring/gcd_num).append("/").append(num/gcd_num).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int gcd(int a, int b) {
		int c;
		while(b!=0) {
			c = a%b;
			a = b;
			b = c;
		}
		return a;
	}
}