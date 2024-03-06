import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int AAtk = Integer.parseInt(st.nextToken());
        int AHp = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int BAtk = Integer.parseInt(st.nextToken());
        int BHp = Integer.parseInt(st.nextToken());

        while(AHp > 0 && BHp > 0){
            BHp -= AAtk;
            AHp -= BAtk;
        }

        if(AHp <= 0){
            if(BHp <= 0) sb.append("DRAW");
            else sb.append("PLAYER B");
        }
        else sb.append("PLAYER A");
        System.out.println(sb);
        br.close();
    }
}