import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0, stat = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr, Collections.reverseOrder());
        int num = Math.min(N, 42);
        for(int i = 0 ; i < num; i++){
            int level = arr.get(i);
            if(level >= 250)      stat += 5;
            else if(level >= 200) stat += 4;
            else if(level >= 140) stat += 3;
            else if(level >= 100) stat += 2;
            else if(level >= 60)  stat += 1;
            sum += level;
        }
        System.out.print(sum + " " + stat);
        br.close();
    }
}