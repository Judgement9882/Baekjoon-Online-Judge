import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int len = str.length() - 2;
        sb.append("h");
        for(int i = 0; i < len*2; i++) sb.append("e");
        sb.append("y");

        System.out.print(sb);
        br.close();
    }
}