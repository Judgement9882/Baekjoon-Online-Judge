import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean a = checkSeven(N);
        boolean b = divideBySeven(N);
        if(!a&&!b) System.out.println(0);
        if(!a&&b) System.out.println(1);
        if(a&&!b) System.out.println(2);
        if(a&&b) System.out.println(3);
        br.close();
    }

    public static boolean checkSeven(int N){
        while(N>0){
            if(N%10==7) return true;
            N/=10;
        }
        return false;
    }

    public static boolean divideBySeven(int N){
        if(N%7==0) return true;
        return false;
    }
}