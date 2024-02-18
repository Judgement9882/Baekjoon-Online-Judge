import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            minX = Math.min(minX, A);
            minY = Math.min(minY, B);
            maxX = Math.max(maxX, A);
            maxY = Math.max(maxY, B);
        }
        sb.append((maxX-minX) * (maxY-minY));
        System.out.println(sb);
        br.close();
    }
}