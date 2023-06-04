import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String temp = "";
//		while((temp = br.readLine()) != null) {
//			System.out.println(temp);
//		}
		
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean f = false;
		for(int i = 0 ; i < 8; i++) {
			int N = Integer.parseInt(st.nextToken());
			if(N==9) {
				f = true;
				break;
			}
		}
		if(f) sb.append("F");
		else sb.append("S");
		System.out.println(sb);
		br.close();
	}
}