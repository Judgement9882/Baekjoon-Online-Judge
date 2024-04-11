import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double N = Double.parseDouble(br.readLine());
        sb.append(3.785411784*100000/1609.344/N);
        System.out.print(sb);
        br.close();
    }
}