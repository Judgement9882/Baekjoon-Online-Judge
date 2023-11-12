import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            String temp = br.readLine();
            if(temp.equals("Algorithm")) sb.append("204\n");
            else if(temp.equals("DataAnalysis")) sb.append("207\n");
            else if(temp.equals("ArtificialIntelligence")) sb.append("302\n");
            else if(temp.equals("CyberSecurity")) sb.append("B101\n");
            else if(temp.equals("Network")) sb.append("303\n");
            else if(temp.equals("Startup")) sb.append("501\n");
            else if(temp.equals("TestStrategy")) sb.append("105\n");
        }
        System.out.println(sb);
        br.close();
    }
}