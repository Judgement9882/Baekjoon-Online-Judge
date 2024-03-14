import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()));
        System.out.println(sb);
        br.close();
    }
}