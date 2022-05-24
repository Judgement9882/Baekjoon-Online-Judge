#include <iostream>

using namespace std;

int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int T, N, num, S=0;
    cin >> T;
    while(T--){
        cin >> N;
        while(N--){
            cin >> num;
            S += num;
        }
        cout << S << "\n";
        S = 0;
    }
    
    return 0;
}