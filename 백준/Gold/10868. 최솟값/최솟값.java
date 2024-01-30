import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static final long div = 1_000_000_007;
    static long arr[];
//    static long segTree[];
    static long minSegTree[];
//    static long maxSegTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());
        // 높이 = 올림 lg N
        int H = (int)Math.ceil(Math.log(N) / Math.log(2));
        // 배열의 크기 = 2 ^ (H+1) - 1
        int size = (1<<(H+1));
        minSegTree = new long[size];
//        maxSegTree = new long[size];

        minInit(1, 0, N-1);
//        maxInit(1, 0, N-1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
//            sb.append(query(1, 0, N-1, a-1, b-1)).append("\n");
            sb.append(minQuery(1, 0, N-1, a-1, b-1)).append("\n");
//            sb.append(maxQuery(1, 0, N-1, a-1, b-1)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void minInit(int node, int start, int end){
        // 리프노드 => 원래 값 입력
        if(start==end){
            minSegTree[node] = arr[start];
        }
        else{
            // 왼쪽, 오른쪽 자식 노드
            minInit(node*2, start, (start+end)/2);
            minInit(node*2+1, (start+end)/2+1, end);
            minSegTree[node] = Math.min(minSegTree[node*2], minSegTree[node*2+1]);
        }
    }

//    static void maxInit(int node, int start, int end){
//        // 리프노드 => 원래 값 입력
//        if(start==end){
//            maxSegTree[node] = arr[start];
//        }
//        else{
//            // 왼쪽, 오른쪽 자식 노드
//            maxInit(node*2, start, (start+end)/2);
//            maxInit(node*2+1, (start+end)/2+1, end);
//            maxSegTree[node] = Math.max(maxSegTree[node*2], maxSegTree[node*2+1]);
//        }
//    }

//    static void update(int node, int start, int end, int index, long val){
//        // index 범위 밖이면 return
//        if(index < start || end < index) return;
//
//        // 리프노드라면 index 번째 수를 val로 바꾸고
//        // 해당 위치의 segTree의 node도 val로 바꾸고
//        if(start==end){
//            arr[index] = val;
//            segTree[node] = val;
//            return;
//        }
//
//        // 리프노드가 아니라면 리프노드를 찾으러 내려감
//        update(node*2, start, (start+end)/2, index, val);
//        update(node*2+1, (start+end)/2+1, end, index, val);
//
//        // 재귀적으로 부모 노드 값 갱신
//        segTree[node] = (segTree[node*2] * segTree[node*2+1])%div;
//    }

    /*
        기본적으로 start와 end 안에 left, right가 있음 (left, right 사이 값 구하기)
        자식 노드로 가면서 start와 end가 반토막이 나면서 어느 순간
        left <= start && end <= right 되는 구간 존재한다? => 그 노드는 적합한 영역
        right가 start보다 작거나 left가 end보다 크면 말도 안되는 구간 => 부적합
     */
//    static long query(int node, int start, int end, long left, long right){
//        // 범위 밖이면 1
//        if(right < start || end < left) return 1;
//
//        // 적합한 영역
//        if(left <= start && end <= right){
//            return segTree[node];
//        }
//
//        long lsum = query(node*2, start, (start+end)/2, left, right);
//        long rsum = query(node*2+1, (start+end)/2+1, end, left, right);
//        return (lsum*rsum)%div;
//    }

    static long minQuery(int node, int start, int end, long left, long right){
        // 범위 밖이면 out
        if(right < start || end < left) return Long.MAX_VALUE;

        // 적합한 영역
        if(left <= start && end <= right){
            return minSegTree[node];
        }

        long lsum = minQuery(node*2, start, (start+end)/2, left, right);
        long rsum = minQuery(node*2+1, (start+end)/2+1, end, left, right);
        return Math.min(lsum,rsum);
    }

//    static long maxQuery(int node, int start, int end, long left, long right){
//        // 범위 밖이면 out
//        if(right < start || end < left) return 1;
//
//        // 적합한 영역
//        if(left <= start && end <= right){
//            return maxSegTree[node];
//        }
//
//        long lsum = maxQuery(node*2, start, (start+end)/2, left, right);
//        long rsum = maxQuery(node*2+1, (start+end)/2+1, end, left, right);
//        return Math.max(lsum,rsum);
//    }
}