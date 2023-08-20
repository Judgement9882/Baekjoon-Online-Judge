import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Input = br.readLine();
		HashSet<Integer> P = new HashSet<>();
		HashSet<Integer> K = new HashSet<>();
		HashSet<Integer> H = new HashSet<>();
		HashSet<Integer> T = new HashSet<>();
		
		boolean GRESKA = false;
		for(int index = 0; index < Input.length(); index+=3) {
			char c = Input.charAt(index);
			int ten = (Input.charAt(index+1) - '0')*10;
			int one = Input.charAt(index+2) - '0';
			switch (c) {
			case 'P':
				if(P.contains(ten+one)) GRESKA = true;
				P.add(ten+one);
				break;
			case 'K':
				if(K.contains(ten+one)) GRESKA = true;
				K.add(ten+one);
				break;
			case 'H':
				if(H.contains(ten+one)) GRESKA = true;
				H.add(ten+one);
				break;
			case 'T':
				if(T.contains(ten+one)) GRESKA = true;
				T.add(ten+one);
				break;
			default:
				break;
			}
		}
		if(GRESKA) System.out.println("GRESKA");
		else {
			StringBuilder sb = new StringBuilder();
			sb
			.append(13-P.size()).append(" ")
			.append(13-K.size()).append(" ")
			.append(13-H.size()).append(" ")
			.append(13-T.size());
			System.out.println(sb);
		}
		
		br.close();
	}
}