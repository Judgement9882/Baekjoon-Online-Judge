import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double A = sc.nextInt();
		double B = sc.nextInt();
		double C = sc.nextInt();
		
		System.out.println((int)(B/A*3*C));
		
		sc.close();
	}

}
