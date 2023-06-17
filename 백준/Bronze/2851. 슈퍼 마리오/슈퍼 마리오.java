import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int ans = 0, temp = 0, end = 0;
		for(int i = 0 ; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			if(ans==0) { // 답이 안나왔을때만
				if(temp + num >= 100) { // 마지막 경우
					if(Math.abs(100-temp) >= Math.abs(temp+num-100)) {
						ans = temp+num;
					}
					else ans = temp;
				}
				else temp += num;
			}
			end += num;
		}
		System.out.println(ans==0?end:ans);
//		System.out.println(sb);
		br.close();
	}
}