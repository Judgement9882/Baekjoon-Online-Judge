#include <iostream>

using namespace std;

int student[31];

int main(){
    
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n = 28, temp;
    while(n--){
        cin >> temp;
        student[temp] = 1;
    }
    for(int i = 1; i<=30; i++){
        if(student[i] == 0) cout << i << "\n";
    }
    return 0;
}