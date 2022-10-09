/*
    https://www.acmicpc.net/problem/8723

    스틱
*/

#include <iostream>
#include <algorithm>

using namespace std;



int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    
    int a, b, c;
    cin >> a >> b >> c;
    if (a == b && b == c) cout << "2";
    else {
        
        if (a < b) swap(a, b);
        if (a < c) swap(a, c);

        if (a * a == b * b + c * c) cout << "1";
        else cout << "0";
    }

    return 0;
}
