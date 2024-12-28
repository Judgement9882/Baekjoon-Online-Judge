import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		char [] noun = {'a', 'e', 'i', 'o', 'u'};
		char [] es1 = {'o', 's', 'x'};
//		String [] es2 = {"ch", "sh"};
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			String src = st.nextToken();
			String des = st.nextToken();
			map.put(src, des);
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			if(map.containsKey(query)) {
				sb.append(map.get(query)).append("\n");
			}
			else {
				if(query.charAt(query.length()-1) == 'y') {
					boolean isNoun = false;
					char c2 = query.charAt(query.length()-2);
					for(char c : noun) {
						if(c == c2) isNoun = true;
					}
					if(!isNoun) {
						sb.append(query.substring(0, query.length()-1)).append("ies").append("\n");
					}else {
						sb.append(query).append('s').append("\n");
					}
				}
				else {
					boolean isEs = false;
					char c1 = query.charAt(query.length()-1);
					char c2 = query.charAt(query.length()-2);
					for(char c : es1) {
						if(c == c1) isEs = true;
					}
					// ch, sh check
					if((c2 == 'c' && c1 == 'h') || (c2 == 's') && (c1 == 'h')) {
						isEs = true;
					}
					
					if(isEs) {
						sb.append(query).append("es").append("\n");
					}else {
						sb.append(query).append('s').append("\n");
					}
				}
			}
			
		}
		System.out.println(sb);
		br.close();
	}
}