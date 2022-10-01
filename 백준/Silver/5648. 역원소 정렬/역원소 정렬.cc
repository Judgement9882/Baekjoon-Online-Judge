/*
    https://www.acmicpc.net/problem/5648

    역원소정렬
*/


#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int N;
long long num[1000002];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N;
    
    for (int i = 0; i < N; i++) {
        string temp; cin >> temp;
        

        int leng = temp.length() - 1;
        
        while (temp[leng] == '0') leng--;
        
        string temp2;
        for (int j = leng; j >= 0; j--) {
            temp2.push_back(temp[j]);
        }
        
        
        
        num[i] = stol(temp2);
    }
    
    sort(num, num + N);
    for (int i = 0; i < N; i++) {
        cout << num[i] << "\n";
    }


    return 0;
}
