#include <iostream>

using namespace std;

int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, num;
    cin >> N;
    while(1){
        cin >> num;
        if (num == 0) break;
        if (num % N == 0) cout << num << " is a multiple of " << N << ".\n";
        else cout << num << " is NOT a multiple of " << N << ".\n";
    }
    
    return 0;
}