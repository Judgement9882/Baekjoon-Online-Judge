import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        if(temp.equals("fdsajkl;") || temp.equals("jkl;fdsa")) System.out.print("in-out");
        else if(temp.equals("asdf;lkj") || temp.equals(";lkjasdf")) System.out.print("out-in");
        else if(temp.equals("asdfjkl;")) System.out.print("stairs");
        else if(temp.equals(";lkjfdsa")) System.out.print("reverse");
        else System.out.print("molu");
        br.close();
    }
}