import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int pos = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-->0){
            pos += Integer.parseInt(st.nextToken());
        }
        if(pos > 0) System.out.println("Right");
        else if (pos < 0 ) System.out.println("Left");
        else System.out.println("Stay");
        br.close();
    }
}