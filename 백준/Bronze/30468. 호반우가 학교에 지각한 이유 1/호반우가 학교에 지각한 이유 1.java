import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stat = 0;
        int N= 4;

        while(N-->0) stat += Integer.parseInt(st.nextToken());
        int avg = stat / 4;
        int num = Integer.parseInt(st.nextToken());
        if(avg >= num) System.out.println(0);
        else System.out.println(num*4 - stat);
        br.close();
    }
}