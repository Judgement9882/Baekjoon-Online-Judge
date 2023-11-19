import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(N<425) sb.append("Violet");
        else if(N<450) sb.append("Indigo");
        else if(N<495) sb.append("Blue");
        else if(N<570) sb.append("Green");
        else if(N<590) sb.append("Yellow");
        else if(N<620) sb.append("Orange");
        else if(N<=780) sb.append("Red");
        System.out.println(sb);
        br.close();
    }
}