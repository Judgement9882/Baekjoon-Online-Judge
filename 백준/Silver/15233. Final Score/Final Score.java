import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        HashSet<String> aSet = new HashSet<>();
        HashSet<String> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < A; i++) aSet.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < B; i++) bSet.add(st.nextToken());
        int aScore = 0, bScore = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < G; i++){
            if(aSet.contains(st.nextToken())) aScore++;
            else bScore++;
        }
        if(aScore > bScore) System.out.print("A");
        else if(aScore < bScore) System.out.print("B");
        else System.out.print("TIE");

        br.close();
    }
}