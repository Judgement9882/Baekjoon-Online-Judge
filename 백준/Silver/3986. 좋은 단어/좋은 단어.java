import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			ArrayDeque<Character> s = new ArrayDeque<>();
			for(int j = 0; j < temp.length(); j++) {
				if(s.isEmpty()) s.push(temp.charAt(j));
				else {
					// 만약 매칭된다면
					if(s.peek() == temp.charAt(j)) {
						s.pop();
					}
					// 매칭 안된다면
					else {
						s.push(temp.charAt(j));
					}
				}
			}
			if(s.isEmpty()) ans++;
		}
		System.out.println(ans);
		br.close(); 
	}
}