#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

// 초기화
void init(vector<long long>& arr, vector<long long>& tree, int node, int start, int end) {
    if (start == end) {
        tree[node] = arr[start];
    }
    else {
        init(arr, tree, node * 2, start, (start + end) / 2);
        init(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}

// 갱신
void update(vector<long long>& tree, int node, int start, int end, int index, long long val) {
    if (index < start || index > end) {
        return;
    }
    if (start == end) {
        tree[node] = val;
        return;
    }
    update(tree, node * 2, start, (start + end) / 2, index, val);
    update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

long long query(vector<long long>& tree, int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
        return 0;
    }
    if (left <= start && end <= right) {
        return tree[node];
    }
    long long lsum = query(tree, node * 2, start, (start + end) / 2, left, right);
    long long rsum = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    return lsum + rsum;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    while(T--){
        int N, M; // 수의 개수, 구간 합 구하는 개수
        cin >> N >> M;
    
        vector<long long> arr(N); // 입력 값
        int h = (int)ceil(log2(N)); // 트리의 높이
        int tree_size = (1 << (h + 1)); // 트리의 크기
        vector<long long> tree(tree_size); // 트리
        for (int i = 0; i < N; i++) {
            cin >> arr[i]; // 입력
        }
        init(arr, tree, 1, 0, N - 1);
        while (M--) {    
            int b, c;
            cin >> b>> c;
            cout << query(tree, 1, 0, N - 1, b, c) << '\n';
        }
        cout << "\n";
    }
    return 0;
}