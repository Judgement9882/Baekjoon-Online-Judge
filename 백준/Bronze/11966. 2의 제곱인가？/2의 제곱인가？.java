import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean ans = true;
        while(N>1){
            if((N & 0x1) == 1) ans = false;
            N >>= 1;
        }
        if(N==0) ans = false;
        System.out.println(ans?"1":"0");
        br.close();
    }
}