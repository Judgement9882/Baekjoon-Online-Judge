#include <iostream>

using namespace std;

int main(){
    
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, M;
    cin >> N;
    for (int i = 0 ; i < 9; i++){
        cin >> M;
        N -= M;
    }
    cout << N;
    
    return 0;
}