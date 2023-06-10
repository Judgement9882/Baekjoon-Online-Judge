import java.io.*;
import java.util.*;
public class Main {
	static class Point{
		long x;
		long y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point A, B, C, D;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())); 
		B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())); 
		D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		
		if(doIntersect()) System.out.println(1);
		else System.out.println(0);
		br.close();
	}
	
	static boolean doIntersect() {
		int ABC = ccw(A, B, C);
		int ABD = ccw(A, B, D);
		int CDA = ccw(C, D, A);
		int CDB = ccw(C, D, B);
		
		// 두 선분에 대한 방향이 모두 다르면 교차함. 		
		if(ABC * ABD == -1 && CDA * CDB == -1) return true;

		// 선분 위에 올라가 있는 경우 고려
		// 올라가 있을 경우, 원래 이어져 있는 AB 사이에 C, D가 있어야함
		// 원래 이어져 있는 CD 사이에 A, B가 있어야함
		if(ABC==0 && onSegment(A, C, B)) return true;
		if(ABD==0 && onSegment(A, D, B)) return true;
		if(CDA==0 && onSegment(C, A, D)) return true;
		if(CDB==0 && onSegment(C, B, D)) return true;
		return false;
	}
	
	static int ccw(Point a, Point b, Point c) {
		long r = (b.y-a.y)*(c.x-b.x) - (b.x-a.x)*(c.y-b.y);
		if(r>0) return 1; // clock
		else if(r<0) return -1; // counterclockwise
		return 0; // collinear
	}
	
	// 참고 : https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
	static boolean onSegment(Point a, Point b, Point c) {
		// b 점의 좌표는 a, c 사이에 있어야함
		if(b.x <= Math.max(a.x, c.x) && b.x >= Math.min(a.x, c.x) && b.y <= Math.max(a.y, c.y) && b.y >= Math.min(a.y, c.y)) {
//			if() {
				return true;
//			}
		}
		return false;
	}
}