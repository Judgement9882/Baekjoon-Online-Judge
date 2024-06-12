#include <iostream>
#include <string>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    cin.ignore();
    while (N--) {
        string temp; 
        getline(cin, temp);
        cout << temp;
        if (temp.length() > 0 && temp[temp.length() - 1] != '.') cout << '.';
        cout << "\n";
    }
    return 0;
}