#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m, n;
    cin >> m >> n;
    string ans = (m >= 8 ? "satisfactory" : "unsatisfactory");
    while (m--) {
        for(int i = 0; i < n; i++){
            int temp; cin >> temp;
        }
    }
    cout << ans;
    
    return 0;
}