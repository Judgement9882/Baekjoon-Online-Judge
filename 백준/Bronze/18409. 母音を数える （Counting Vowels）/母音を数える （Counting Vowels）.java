import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		int ans = 0;
		for(int i = 0 ;  i< N; i++) {
			char c = temp.charAt(i);
			if(c=='a' || c=='e' || c=='o' || c=='i' || c=='u') ans++;
		}
		
		System.out.println(ans);
		br.close();
	}
}
