import java.io.*;
import java.util.*;
public class Main {

    static class Nation {
        int index;
        int gold;
        int silver;
        int bronze;
        Nation(int index,
        int gold,
        int silver,
        int bronze){
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Nation> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr.add(new Nation(index, gold, silver, bronze));
        }

        Collections.sort(arr, (o1, o2) -> {
            int r = Integer.compare(o1.gold, o2.gold);
            if(r!=0) return r;
            else {
                r = Integer.compare(o1.silver, o2.silver);
                if(r!=0) return r;
                else{
                    return Integer.compare(o1.bronze, o2.bronze);
                }
            }
        });
        int rank = 1;
        int same = 0;
        if(arr.get(0).index == K) System.out.print("1");
        else{
            for(int i = 1 ; i < N; i++){
//                System.out.print(rank);
                Nation prev = arr.get(i-1);
                Nation cur = arr.get(i);
                // same
                if(prev.gold == cur.gold && prev.silver==cur.silver && prev.bronze == cur.bronze){
                    same++;
                }
                else{
                    rank += same + 1;
                    same = 0;
                }

                if(cur.index==K) {
                    System.out.print(rank);
                    break;
                }
            }
        }

        br.close();
    }
}