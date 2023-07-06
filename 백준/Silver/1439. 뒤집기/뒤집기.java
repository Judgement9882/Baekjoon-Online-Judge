import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int zero = 0, one = 0;

        for(int i = 1 ; i < S.length(); i++){
            if(S.charAt(i) != S.charAt(i-1)){
                if(S.charAt(i) == '0') zero++;
                else one++;
            }
        }
        System.out.println(Math.max(one,zero));
        br.close();
    }
}