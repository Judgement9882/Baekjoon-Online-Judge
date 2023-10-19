import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long zip_sleep = (N-1)/8;
        long zip_time = N + zip_sleep*S;

        long dok_sleep = (M-1)/8;
        long dok_time = M + T + dok_sleep*(S + T*2);

        if(zip_time < dok_time) System.out.print("Zip\n"+zip_time);
        else System.out.print("Dok\n"+dok_time);

        br.close();
    }
}