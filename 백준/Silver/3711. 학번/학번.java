import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        end2 : while(N-->0){
            int G = Integer.parseInt(br.readLine());
            int [] arr = new int[G];
            for(int i = 0; i < G; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            end : for(int i = 1; i < Integer.MAX_VALUE; i++){
                set.clear();
                for(int j = 0; j < G; j++){
                    int num = arr[j] % i;
                    if(set.contains(num)) continue end;
                    set.add(num);
                }

                sb.append(i).append("\n");
                continue end2;
            }
        }
        System.out.println(sb);
        br.close();
    }
}