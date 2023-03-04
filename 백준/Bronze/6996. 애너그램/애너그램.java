import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		end : for(int i =0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			String B = st.nextToken();
			
			if(A.length() != B.length()) {
				sb.append(A).append(" & ").append(B).append(" are NOT anagrams.\n");
				continue;
			}
			
			int alpha[] = new int[26];
			for(int j = 0; j < A.length(); j++) {
				alpha[A.charAt(j) - 'a']++;
				alpha[B.charAt(j) - 'a']--;
			}
			
			for(int j = 0; j < 26; j++) {
				if(alpha[j] != 0) {
					sb.append(A).append(" & ").append(B).append(" are NOT anagrams.\n");
					continue end;
				}
			}
			
			sb.append(A).append(" & ").append(B).append(" are anagrams.\n");
		}
		System.out.println(sb);
		br.close();
	}
}