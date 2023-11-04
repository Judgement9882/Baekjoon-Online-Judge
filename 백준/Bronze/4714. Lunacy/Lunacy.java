import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            Double d = Double.parseDouble(br.readLine());
            if(d==-1.0) break;
            sb
                    .append("Objects weighing ")
                    .append(String.format("%.2f", d))
                    .append(" on Earth will weigh ")
                    .append(String.format("%.2f", d*0.167))
                    .append(" on the moon.\n");
        }
        System.out.println(sb);
        br.close();
    }
}