import java.util.*;
import java.io.*;
public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			if(temp.length() < M) continue;
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
		ArrayList<String> word = new ArrayList<>();
		for(String s : map.keySet()) {
			word.add(s);
		}
		Collections.sort(word, (o1, o2)->{
			int r = -Integer.compare(map.get(o1), map.get(o2));
			if(r==0) {
				int r1 = -Integer.compare(o1.length(), o2.length());
				if(r1==0) {
					return o1.compareTo(o2);
				}
				return r1;
			}
			return r;
		});
		StringBuilder sb = new StringBuilder();
		for(String s : word) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}