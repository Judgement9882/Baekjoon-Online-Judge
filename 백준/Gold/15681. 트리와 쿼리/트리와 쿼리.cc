#include <bits/stdc++.h>
#define MAX_N 100001
using namespace std;
vector<int> line[MAX_N];
vector<int> childeren[MAX_N];
int parents[MAX_N];
int N, R, Q;

void makeTree(int node, int parent) {
    for (auto k : line[node]) {
        if (k != parent) {
            childeren[node].push_back(k);
            parents[k] = node;
            makeTree(k, node);
        }
    }
}

void countSubTreeNodes(vector<int> &size, int node) {
    size[node] = 1;
    for (auto k : childeren[node]) {
        countSubTreeNodes(size, k);
        size[node] += size[k];
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> R >> Q;

    for (int i = 0; i < N - 1; i++) {
        int u, v;
        cin >> u >> v;
        line[u].push_back(v);
        line[v].push_back(u);
    }

    // 1. maketree
    makeTree(R, -1);

    vector<int> size(N+1);
    countSubTreeNodes(size, R);

    // 2. query
    while (Q--) {
        int u; cin >> u;
        cout << size[u] << "\n";
    }

    return 0;
}