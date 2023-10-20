import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i= 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 마지막 순열인지 확인

        boolean last = true;
        for(int i = 0 ; i < N; i++){
            if(A[i] != N-i){
                last = false;
                break;
            }
        }
        if(last) System.out.println("-1");
        else {
            // 1. 더 작은수를 찾을때까지 확인
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = N - 1; i >= 1; i--) {
                // 2. 리스트에 일단 담음
                list.add(A[i]);
                if(A[i] < A[i-1]) continue; // 더 크면 continue;

                // 3. 작은수를 찾았다면 리스트에서 찾은 작은수 보다 가장 가깝게 큰 수를 작은수의 자리로 이동
                else{
                    int num = A[i-1];
                    // 정렬
                    Collections.sort(list);
                    for(int j = 0 ; j < list.size(); j++){
                        if(num < list.get(j)){
                            A[i-1] = list.get(j);
                            list.remove(j);
                            // 4. 찾은 작은수를 리스트에 넣고 정렬함
                            list.add(num);
                            Collections.sort(list);
                            break;
                        }
                    }

                    // 5. 출력
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j <= i-1; j++){
                        sb.append(A[j]).append(" ");
                    }
                    for(int temp : list){
                        sb.append(temp).append(" ");
                    }
                    System.out.println(sb);
                    break;
                }
            }
        }
        br.close();
    }
}