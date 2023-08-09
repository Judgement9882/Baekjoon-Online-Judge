import java.io.*;
import java.util.*;
public class Main {
    static class Pair implements Comparable<Pair>{
        String mento;
        String menti;
        Pair(String mento, String menti){
            this.mento = mento;
            this.menti = menti;
        }

        @Override
        public int compareTo(Pair o) {
            int r = o.mento.compareTo(this.mento);
            if(r!=0) return r;
            else return -o.menti.compareTo(this.menti);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Pair(st.nextToken(), st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Pair temp : list){
            sb.append(temp.mento).append(" ").append(temp.menti).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}