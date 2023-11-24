import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger div = new BigInteger("42");
        while(true){
            String N = br.readLine();
            if(N.equals("0")) break;
            BigInteger num = new BigInteger(N);
            if(num.remainder(div).equals(new BigInteger("0"))) sb.append("PREMIADO\n");
            else sb.append("TENTE NOVAMENTE\n");
        }
        System.out.println(sb);
        br.close();
    }
}