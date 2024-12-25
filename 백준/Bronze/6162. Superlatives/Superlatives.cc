#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    for (int tc = 1; tc <= T; tc++) {
        cout << "Data Set " << tc << ":\n";
        int E, A; cin >> E >> A;
        if (E <= A) cout << "no drought";
        else {
            while (true) {
                A *= 5;
                if (E > A) cout << "mega ";
                else break;
            }
            cout << "drought";
        }
        cout << "\n\n";
    }

    return 0;
}