#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int x, y, z, xs, ys, zs;
    cin >> x >> y >> z >> xs >> ys >> zs;
    if (y > ys * 2) cout << "E";
    else{
        if (ys < y) cout << "D";
        else {
            if (x > xs * 2) cout << "C";
            else {
                if (xs < x) cout << "B";
                else cout << "A";
            }
        }
    }


    return 0;
}