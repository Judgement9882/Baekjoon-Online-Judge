import java.util.*;
import java.io.*;
public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> name = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			name.put(temp, name.getOrDefault(temp, 0)+1);
			set.add(temp);
		}
		while(N-- > 1) {
			String temp = br.readLine();
			name.put(temp, name.get(temp)-1);
		}
		Object[] a = set.toArray();
		for(Object b : a) {
			if(name.get(b) > 0) {
				System.out.println(b);
				break;
			}
		}
		br.close();
	}
}