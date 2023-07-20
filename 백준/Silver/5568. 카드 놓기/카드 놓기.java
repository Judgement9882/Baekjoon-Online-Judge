import java.io.*;
import java.util.*;
public class Main {
    static int n, k;
    static int cardList[], selected[];
    static boolean v[];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cardList = new int[n];
        selected = new int[n];
        v = new boolean[n];
        for(int i = 0; i < n ; i++){
            cardList[i] = Integer.parseInt(br.readLine());
        }
        func(0);
        System.out.print(set.size());
        br.close();
    }

    static void func(int rep){
        if(rep == k){ // 기저조건
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < k; i++){
                sb.append(selected[i]);
            }
//            System.out.println(sb.toString());
            set.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!v[i]){
                selected[rep] = cardList[i];
                v[i] = true;
                func(rep+1);
                v[i] = false;
            }
        }
    }
}