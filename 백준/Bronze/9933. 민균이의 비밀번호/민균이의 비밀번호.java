import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			if(!set.contains(temp)) {
				set.add(temp);
				if(set.contains(reverse(temp))) {
					// 리버스 된 문자열을 가지고 있다면
					sb.append(temp.length()).append(" " ).append(temp.charAt(temp.length()/2));
					continue;
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static String reverse(String temp) {
		StringBuilder ret = new StringBuilder();
		ret.append(temp);
		ret.reverse();
		return ret.toString();
	}
}