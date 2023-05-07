import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			String[] str = temp.split("\\.");
			map.put(str[1], map.getOrDefault(str[1], 0)+1);
			set.add(str[1]);
		}
		Object[] arr = set.toArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(Object a : arr) {
			sb.append(a).append(" ").append(map.get(a)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}	
}