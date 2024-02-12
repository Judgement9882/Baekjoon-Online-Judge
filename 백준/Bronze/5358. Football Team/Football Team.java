import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String temp = br.readLine();
            if(temp == null) break;
            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == 'e') sb.append("i");
                else if (temp.charAt(i) == 'i') sb.append("e");
                else if (temp.charAt(i) == 'E') sb.append("I");
                else if (temp.charAt(i) == 'I') sb.append("E");
                else sb.append(temp.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}