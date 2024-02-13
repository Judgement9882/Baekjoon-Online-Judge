import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int big = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(big < a){
            int temp = big;
            big = a;
            a = temp;
        }
        if(big < b){
            int temp = big;
            big = b;
            b = temp;
        }

        if(big == a+b) sb.append(1);
        else if (big == a*b) sb.append(2);
        else sb.append(3);

        System.out.println(sb);
        br.close();
    }
}