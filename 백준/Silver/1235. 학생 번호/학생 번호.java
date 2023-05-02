import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] stu = new String[N];
		for(int i = 0 ; i < N; i++) {
			stu[i] = br.readLine();
		}
		int ans = 1;
		plus : while(true) {
			HashSet<String> set = new HashSet<>();
			if(ans == 100) break;
			for(int i = 0; i < N; i++) {
				String temp = stu[i].substring(stu[i].length()-ans, stu[i].length());
				if(set.contains(temp)) {
					ans++;
					continue plus;
				}
				set.add(temp);
			}
			
			// 여기까지 온거면 다 된거임
			break;
		}
		System.out.println(ans);
		br.close();
	}
}