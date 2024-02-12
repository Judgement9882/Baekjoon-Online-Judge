import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        if(x%2==0) sb.append(0);
        else if (y%2==0) sb.append(0);
        else if(x>y) sb.append(y);
        else sb.append(x);

        System.out.println(sb);
        br.close();
    }
}