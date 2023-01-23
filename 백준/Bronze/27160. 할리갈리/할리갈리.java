import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] s = new int[4];
		
		for(int i = 0; i < N ; i++) {
			String temp; temp = sc.next();
			int num = sc.nextInt();
			if (temp.equals("STRAWBERRY")) {
				s[0] += num;
			}
			else if(temp.equals("BANANA")) {
				s[1] += num;
			}
			else if(temp.equals("LIME")) {
				s[2] += num;				
			}
			else if(temp.equals("PLUM")) {
				s[3] += num;
			}
		}
		String ans = "NO";
		for(int i = 0 ; i < 4; i++) {
			if (s[i] == 5) ans = "YES";
		}
		System.out.println(ans);
		
		sc.close();
	}

}
