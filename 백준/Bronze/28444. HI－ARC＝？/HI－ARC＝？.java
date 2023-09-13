import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());        
        long d = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());        
        System.out.print(a*b-c*d*e);
        br.close();
    }
}