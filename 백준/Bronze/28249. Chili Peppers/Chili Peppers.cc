#include <iostream>
#include <unordered_map>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_map<string, int> pepper;
    pepper.insert({ "Poblano", 1500 });
    pepper.insert({ "Mirasol", 6000 });
    pepper.insert({ "Serrano", 15500 });
    pepper.insert({ "Cayenne", 40000 });
    pepper.insert({ "Thai", 75000 });
    pepper.insert({ "Habanero", 125000 });

    int N; cin >> N;
    int ans = 0;
    while (N--) {
        string p; cin >> p;
        ans += pepper.at(p);
    }
    cout << ans;
    return 0;
}