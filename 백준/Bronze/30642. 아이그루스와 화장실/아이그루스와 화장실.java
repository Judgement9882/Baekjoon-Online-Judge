import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String mas = br.readLine();
        int K = Integer.parseInt(br.readLine());
        if(mas.equals("annyong")){
            if(K%2==0){
                if(K==N) K--;
                else K++;
            }
        }else{
            if(K%2==1){
                if(K==N) K--;
                else K++;
            }
        }
        System.out.println(K);
        br.close();
    }
}