import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int odd = 0, even = 0;
        while(N-->0){
            int num = Integer.parseInt(st.nextToken());
            if(num%2==0) even++;
            else odd++;
        }
        if(even>odd)            System.out.println("Happy");
        else                    System.out.println("Sad");
        br.close();
    }
}