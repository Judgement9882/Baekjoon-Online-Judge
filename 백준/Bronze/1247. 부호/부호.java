import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 3;
        StringBuilder sb = new StringBuilder();
        BigInteger zero = new BigInteger("0");
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            BigInteger num = new BigInteger("0");
            while(N-->0){
                String str = br.readLine();
//                System.out.println("str : " + str);
                BigInteger temp = new BigInteger(str);
                num = num.add(temp);
//                System.out.println("temp : " + temp);
//                System.out.println("num : " + num);
            }

            if(num.compareTo(zero) > 0) sb.append("+\n");
            else if (num.compareTo(zero) < 0) sb.append("-\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
        br.close();
    }
}