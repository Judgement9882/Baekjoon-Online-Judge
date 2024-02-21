import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point A, B, C, D;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        B = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        C = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        System.out.println(ccw(A, B, C));
        br.close();
    }

    static int ccw(Point a, Point b, Point c) {
        int r = (b.y-a.y)*(c.x-b.x) - (b.x-a.x)*(c.y-b.y);
        if(r>0) return -1; // clock
        else if(r<0) return 1; // counterclockwise
        return 0; // collinear
    }
}