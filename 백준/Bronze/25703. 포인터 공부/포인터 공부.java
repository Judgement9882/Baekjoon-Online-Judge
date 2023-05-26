import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("int a;\n").append("int *ptr = &a;\n");
		if(N>=2) {
			sb.append("int **ptr2 = &ptr;\n");
		}
		for(int i = 3; i <= N; i++) {
			sb.append("int ");
			for(int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("ptr").append(i).append(" = &ptr").append(i-1).append(";\n");
		}
		System.out.println(sb);
		br.close();
	}
}