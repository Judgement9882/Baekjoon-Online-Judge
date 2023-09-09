import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char input = br.readLine().charAt(0);
        if(input == 'M') System.out.print("MatKor");
        else if(input == 'W') System.out.print("WiCys");
        else if(input == 'C') System.out.print("CyKor");
        else if(input == 'A') System.out.print("AlKor");
        else if(input == '$') System.out.print("$clear");
        br.close();
    }
}