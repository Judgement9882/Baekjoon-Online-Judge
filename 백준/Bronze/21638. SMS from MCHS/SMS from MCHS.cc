#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t1, v1, t2, v2;
    cin >> t1 >> v1 >> t2 >> v2;

    string WARNING_MEESAGE_1 = "A storm warning for tomorrow! Be careful and stay home if possible!";
    string WARNING_MEESAGE_2 = "MCHS warns! Low temperature is expected tomorrow.";
    string WARNING_MEESAGE_3 = "MCHS warns! Strong wind is expected tomorrow.";
    string WARNING_MEESAGE_4 = "No message";

    if (t2 < 0 && v2 >= 10) cout << WARNING_MEESAGE_1 << "\n";    
    else if (t1 > t2) cout << WARNING_MEESAGE_2 << "\n";
    else if (t1 <= t2 && v1 < v2) cout << WARNING_MEESAGE_3 << "\n";
    else cout << WARNING_MEESAGE_4 << "\n";
    
    return 0;
}