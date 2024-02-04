import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double temp = Double.parseDouble(br.readLine());
		System.out.println(4*Math.sqrt(temp));
		br.close();
	}
}