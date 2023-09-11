import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String ans = "0";
        if(N.equals("SONGDO")) ans = "HIGHSCHOOL";
        if(N.equals("CODE")) ans = "MASTER";
        if(N.equals("2023")) ans = "0611";
        if(N.equals("ALGORITHM")) ans = "CONTEST";
        System.out.print(ans);
        br.close();
    }
}