import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		char []opt = new char[] {'<', '>', '&', '|', '(', ')'}; 
		
		
		ArrayList<String> s = new ArrayList<>();
		while(st.hasMoreTokens()) {
			// st는 공백 제거용
			String temp = st.nextToken();
			ret : for(int i = 0; i < temp.length(); i++) {
				for(char j : opt) {
					if(temp.charAt(i) == j) {
						// 겹치면 여태 쌓았던 sb를 s에 추가
						if(sb.length()>0) {
							s.add(sb.toString());
							sb.setLength(0);
						}
						
						// 만약 &&거나 ||인 경우
						if(j == '|' || j == '&') {
							s.add(String.valueOf(j)+String.valueOf(j));
							i++;
						}
						else s.add(String.valueOf(j));

						continue ret;
					}
				}
				// 문자를 쌓음
				sb.append(temp.charAt(i));
				// 마지막이면 그간 쌓아둔 문자열을 s에 넣음
				if(i==temp.length()-1) {
					if(sb.length()>0) {
						s.add(sb.toString());
						sb.setLength(0);
					}
				}
			}
			
		}
		for(String a : s) sb.append(a + " ");
		System.out.println(sb);
		br.close();
	}
}