import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        HashSet<String> name = new HashSet<>();
        HashMap<String, Integer> clothes = new HashMap<>();
        while(T-->0){
            // init
            name.clear();
            clothes.clear();

            int n = Integer.parseInt(br.readLine());
            while(n-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String inputName = st.nextToken();
                String inputClothes = st.nextToken();

                // 가지고 있지 않을 때 추가
                if(!name.contains(inputClothes)){
                    name.add(inputClothes);
                    clothes.put(inputClothes, 1);
                }else{
                    // 가지고 있을때는 개수 증가
                    clothes.put(inputClothes, clothes.get(inputClothes)+1);
                }
            }

            int ans = 1;
            for(int num : clothes.values()) ans *= (num+1);
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}

/*
2 1 => 3x2 - 1
3 0 => 4 - 1
 */