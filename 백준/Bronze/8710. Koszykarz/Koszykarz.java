import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long k = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		long ans = 0;
		while(k<w) {
			k+=m;
			ans++;
		}
		System.out.println(ans);
		br.close();
	}
}