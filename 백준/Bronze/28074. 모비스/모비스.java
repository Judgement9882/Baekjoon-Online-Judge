import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> set = new HashSet<>();
		String temp = br.readLine();
		for(int i = 0; i < temp.length(); i++) {
			set.add(temp.charAt(i));
		}
		if(set.contains('M') && set.contains('O') && set.contains('B') && set.contains('I') && set.contains('S')) 
				System.out.println("YES");
		else System.out.println("NO");
		
		br.close();
	}
}