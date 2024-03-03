import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        boolean ans = true;
        int num = 0;
        if(str.length()<=1) ans = false;
        else {
            if (str.charAt(0) == '\"') num++;
            if (str.charAt(str.length() - 1) == '\"') num++;
            if (num != 2) {
                ans = false;
            } else {
                if (str.length() == 2) ans = false;
            }
        }
        sb.append(ans==true?str.substring(1, str.length()-1):"CE");
        System.out.print(sb);
        br.close();
    }
}