import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double M = Double.parseDouble(br.readLine());
        if(M<=30.0) M /= 2.0;
        else M = (M-30)*3/2 + 15.0;
        sb.append(M);
        System.out.println(sb);
        br.close();
    }
}