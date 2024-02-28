import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 4;
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            int np = Integer.parseInt(st.nextToken());
            int nq = Integer.parseInt(st.nextToken());

            // 항상 x<p, y<q
            // 1. 겹치지 않는 경우 -> x<p, y<q이기에 x, y, p, q 기준 생각
            if( (np < x) ||
                (nq < y) ||
                (p < nx) ||
                (q < ny)) sb.append("d");

            // 2. 꼭짓점으로만 겹치는 경우 -> 4가지 경우
            else if((x==np && y==nq) ||
                    (x==np && q==ny) ||
                    (p==nx && q==ny) ||
                    (p==nx && y==nq)) sb.append("c");

            // 3. 선으로 겹치는 경우 -> 특정 변이 외곽에서 겹치는 경우
            else if((x==np) ||
                    (y==nq) ||
                    (p==nx) ||
                    (q==ny)) sb.append("b");

            // 4. 그 외는 직사각형으로 겹침
            else sb.append("a");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}