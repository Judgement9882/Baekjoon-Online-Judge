import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
		int ans = 0;
		String keyans = "";
		for(String key : map.keySet()) {
			if(ans < map.get(key)) {
				ans = map.get(key);
				keyans = key;
			}else if (ans==map.get(key)) {
				if(keyans.compareTo(key) > 0) {
					keyans = key;
				}
			}
		}
		System.out.println(keyans);
		br.close();
	}
}