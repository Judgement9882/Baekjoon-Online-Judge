#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T; cin >> T;
    while (T--) {
        bool zack = false;
        bool mack = false;
        int ten = 10;
        while (ten--) {
            int temp; cin >> temp; cout << temp << " ";
            if (temp == 18) mack = true;
            else if (temp == 17) zack = true;
        }
        cout << "\n";
        if (zack && mack) cout << "both";
        else if (zack) cout << "zack";
        else if (mack) cout << "mack";
        else cout << "none";

        cout << "\n\n";
    }
    return 0;
}