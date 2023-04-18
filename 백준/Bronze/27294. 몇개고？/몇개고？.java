import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		if(S==1 || T <= 11 || T > 16) sb.append("280");
		else sb.append("320");
		System.out.println(sb);
		br.close();
	}
}