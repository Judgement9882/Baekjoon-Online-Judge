import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Integer.parseInt(st.nextToken())+0.0;
        double B = Integer.parseInt(st.nextToken())+0.0;
        double M = (B-A)/400;
        System.out.println(1/(1+Math.pow(10, M)));
        br.close();
    }
}