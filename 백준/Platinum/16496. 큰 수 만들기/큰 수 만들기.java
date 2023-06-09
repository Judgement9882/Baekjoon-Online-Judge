import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < N; i++) 
			list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list, (o1, o2)->{
			String s1 = o1.toString();
			String s2 = o2.toString();
			
			// 두 문자열을 합쳤을 때 더 큰수를 앞으로
			return -(s1+s2).compareTo(s2+s1);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int num : list)
			sb.append(num);
		if(sb.charAt(0) == '0') System.out.println(0);
		else System.out.println(sb);
		br.close();
	}
}