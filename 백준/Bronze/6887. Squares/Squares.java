import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i <= 100; i++) {
			if(i*i <= N) ans = i;
		}
		sb.append("The largest square has side length ").append(ans).append(".");
		System.out.println(sb);
	    br.close();
	}
	
}