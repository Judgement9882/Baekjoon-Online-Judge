import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, HashSet<String>> teamMap = new HashMap<>();
		HashMap<String, String> memberMap = new HashMap<>();
		for(int i = 0 ; i < N; i++) {
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			for(int j = 0; j < num; j++) {
				String name = br.readLine();
				if(teamMap.get(team) == null) {
					HashSet<String> s = new HashSet<>();
					s.add(name);
					teamMap.put(team, s);
				}
				else {
					HashSet<String> s = teamMap.get(team);
					s.add(name);
					teamMap.put(team, s);
				}
				memberMap.put(name, team);
			}
		}
		for(int i = 0 ; i < M; i++) {
			String keyword = br.readLine();
			int order = Integer.parseInt(br.readLine());
			if(order == 0) {
				Object [] temp = teamMap.get(keyword).toArray();
				Arrays.sort(temp);
				for(Object s : temp) {
					sb.append(s).append("\n");
				}
			}
			else sb.append(memberMap.get(keyword)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}