import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int HH = Integer.parseInt(st.nextToken()) - 9;
		int MM = Integer.parseInt(st.nextToken());
		System.out.println(HH*60+MM);
		br.close();
	}
}