#include <iostream>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N; cin >> N;
    int a = 0, b = 0;
    while(N--){
        int n1, n2;
        cin >> n1 >> n2;
        if(n1 > n2) a++;
        else if (n1 < n2) b++;
    }
    cout << a << " " << b;
    
    return 0;
}