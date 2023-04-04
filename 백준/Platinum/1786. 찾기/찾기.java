import java.io.*;
import java.util.*;
public class Main {
	
	static String origin, pattern;
	static int [] pi;
	static char[] patterns;
	
	static void getPi() {
		pi = new int[pattern.length()];
		patterns = new char[pattern.length()];
		for(int i = 0; i < pattern.length(); i++) patterns[i] = pattern.charAt(i);
		
		// getPi
		for(int i = 1, j = 0; i < pattern.length(); i++) {
			while(j > 0 && patterns[i] != patterns[j]) {
				// j가 0 이상이고, 패턴이 일치 하지 않는다면
				// j를 pi에 저장된 이전 값으로 보냄
				j = pi[j-1];
			}
			
			// 같다면 그대로 pi를 증가시킴
			if(patterns[i] == patterns[j]) pi[i] = ++j;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine();
		char[] origins = new char[origin.length()];
		for(int i = 0 ; i < origin.length(); i++) origins[i] = origin.charAt(i);
		pattern = br.readLine();
		getPi();
		int ans = 0;
		List<Integer> pos = new ArrayList<>();
		for(int i = 0, j = 0; i < origin.length(); i++) {
			while(j > 0 && origins[i] != patterns[j]) {
				// j가 0 이상이고, 패턴이 일치 하지 않는다면
				// j를 pi에 저장된 이전 값으로 보냄
				j = pi[j-1];
			}
			
			if(origins[i] == patterns[j]) {
				// 패턴 검색 성공
				if (j == pattern.length()-1) { // 마지막까지 도달했다면 완료
					ans++;
					pos.add(i -pattern.length() + 1);
					j = pi[j]; // 이전 부분배열로 다시 돌아가서 탐색진행
				}
				// 마지막이 아니라면 j를 증가시켜가며 비교
				else ++j;
			}
			
		}
		System.out.println(ans);
		for(int i : pos) System.out.print((i+1) + " "); // 문제에서는 1-indexed 시작
		
		br.close();
	}
}