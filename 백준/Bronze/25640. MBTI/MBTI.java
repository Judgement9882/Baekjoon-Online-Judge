import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mbti = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		while(N-->0) {
			if(mbti.equals(br.readLine())) ans++;
		}
		System.out.println(ans);
		br.close();
	}
}