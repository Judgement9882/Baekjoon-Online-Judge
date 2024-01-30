import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static final long div = 1_000_000_007;
    static long arr[];
    static long segTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());
        // 높이 = 올림 lg N
        int H = (int)Math.ceil(Math.log(N) / Math.log(2));
        // 배열의 크기 = 2 ^ (H+1) - 1
        int size = (1<<(H+1));
        segTree = new long[size];

        init(1, 0, N-1);

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());

            // a가 1인 경우 b번째 수를 c로 바꾸고
            // a가 2인 경우 b번째 수부터 c번째 수까지의 곱 출력
            if      (a==1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                // b번째 -> a[b-1]
                update(1, 0, N-1, b-1, c);

            }
            else if (a==2) {
                // b, c 번째 -> a[b-1], a[c-1]
                long b = Long.parseLong(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                sb.append(query(1, 0, N-1, b-1, c-1)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static void init(int node, int start, int end){
        // 리프노드 => 원래 값 입력
        if(start==end){
            segTree[node] = arr[start];
        }
        else{
            // 왼쪽, 오른쪽 자식 노드
            init(node*2, start, (start+end)/2);
            init(node*2+1, (start+end)/2+1, end);
            segTree[node] = (segTree[node*2] * segTree[node*2+1])%div;
        }
    }

    static void update(int node, int start, int end, int index, long val){
        // index 범위 밖이면 return
        if(index < start || end < index) return;

        // 리프노드라면 index 번째 수를 val로 바꾸고
        // 해당 위치의 segTree의 node도 val로 바꾸고
        if(start==end){
            arr[index] = val;
            segTree[node] = val;
            return;
        }

        // 리프노드가 아니라면 리프노드를 찾으러 내려감
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);

        // 재귀적으로 부모 노드 값 갱신
        segTree[node] = (segTree[node*2] * segTree[node*2+1])%div;
    }

    /*
        기본적으로 start와 end 안에 left, right가 있음 (left, right 사이 값 구하기)
        자식 노드로 가면서 start와 end가 반토막이 나면서 어느 순간
        left <= start && end <= right 되는 구간 존재한다? => 그 노드는 적합한 영역
        right가 start보다 작거나 left가 end보다 크면 말도 안되는 구간 => 부적합
     */
    static long query(int node, int start, int end, long left, long right){
        // 범위 밖이면 1
        if(right < start || end < left) return 1;

        // 적합한 영역
        if(left <= start && end <= right){
            return segTree[node];
        }

        long lsum = query(node*2, start, (start+end)/2, left, right);
        long rsum = query(node*2+1, (start+end)/2+1, end, left, right);
        return (lsum*rsum)%div;
    }

}