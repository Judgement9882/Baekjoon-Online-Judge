import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> s = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 4; i++) {
			s.put(Integer.parseInt(st.nextToken()), i);
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		if(s.containsKey(x)) System.out.println(s.get(x));
		else System.out.println(0);
		
		br.close();
	}
}