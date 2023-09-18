import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())-1;
        int B = Integer.parseInt(st.nextToken());
        System.out.print(Math.min(A, B)*2+1);
        br.close();
    }
}