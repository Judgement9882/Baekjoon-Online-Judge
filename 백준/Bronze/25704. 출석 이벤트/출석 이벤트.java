import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int ans = P;
		if(N>=5) ans = Math.min(ans, Math.max(P-500, 0));
		if(N>=10) ans = Math.min(ans, P*9/10);
		if(N>=15) ans = Math.min(ans, Math.max(P-2000, 0));
		if(N>=20) ans = Math.min(ans, P*75/100);
		System.out.println(ans);
		br.close();
	}
}