import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;
        while(A!=B){
            ans++;
            if(A%2==1) A = (A+1)/2;
            else A /= 2;
            if(B%2==1) B = (B+1)/2;
            else B /= 2;
        }
        System.out.print(ans==0?-1:ans);
        br.close();
    }
}