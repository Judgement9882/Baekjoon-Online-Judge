#include <iostream>
#define MAX_N 201
using namespace std;
int arr[MAX_N];
int N;

void program(){
    for(int i = 0; i < N-1; i++){
        int arri = arr[i];
        int num = 0;
        for(int j = i+1; j < N; j++){
            if(arri < arr[j]) num++;
        }
        arr[i] = num;
    }
    arr[N-1] = 0;
}

bool checkZero(){
    for(int i = 0; i < N; i++){
        if(arr[i] != 0) return false;
    }
    return true;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N;
    for(int i = 0; i < N; i++) cin >> arr[i];
    int ans = 0;
    while(++ans){
        if(checkZero()) break;
        program();
    }
    cout << ans;
    return 0;
}