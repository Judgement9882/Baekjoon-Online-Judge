import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String temp = br.readLine();
		int s = 0, b = 0;
		for(int index= 0; index < temp.length();) {
			if(temp.charAt(index) == 's') {
				s++;
				index += 8;
			}
			else {
				b++;
				index += 7;
				
			}
		}
		
		if(s > b ) System.out.println("security!");
		else if (b > s ) System.out.println("bigdata?");
		else System.out.println("bigdata? security!");
		
	}
}
