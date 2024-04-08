import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = "SciComLove";
        if(N%2==0) sb.append(str);
        else sb.append(str).reverse();
        System.out.println(sb);
        br.close();
    }
}