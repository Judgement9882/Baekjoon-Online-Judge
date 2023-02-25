import java.io.*;
import java.util.*;
public class Main{
	static HashMap<String, Integer> Sdict = new HashMap<>();
	static HashMap<Integer, String> Idict = new HashMap<>();
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i <= N; i++) {
			String temp = br.readLine();
			Sdict.put(temp, i);
			Idict.put(i, temp);
		}
		
		for(int i = 0 ; i < M; i++) {
			String temp = br.readLine();
			// 숫자
			if(1 <= temp.charAt(0) - '0' && temp.charAt(0) - '0' <= 9) {
				System.out.println(Idict.get(Integer.parseInt(temp)));
			}
			else {
				System.out.println(Sdict.get(temp));
			}
		}
		
	}
}

