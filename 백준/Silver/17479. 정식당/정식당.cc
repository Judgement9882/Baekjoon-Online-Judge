#include <iostream>
#include <unordered_map>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, B, C; cin >> A >> B >> C;
    unordered_map<string, int> menu[3];
    unordered_map<string, int> menu_type;
    long normal = 0, total = 0;    
    string temp; int price;
    
    
    for (int i = 0; i < A; i++) {
        cin >> temp >> price;
        menu[0].insert({ temp, price });
        menu_type.insert({ temp, 0});
    }
    for (int i = 0; i < B; i++) {
        cin >> temp >> price;
        menu[1].insert({ temp, price });
        menu_type.insert({ temp, 1 });
    }
    for (int i = 0; i < C; i++) {
        cin >> temp;
        menu[2].insert({ temp, 0 });
        menu_type.insert({ temp, 2 });
    }

    int N; cin >> N;
    string str;
    int num_special = 0, num_service = 0;
    while (N--) {
        cin >> str;
        int index = menu_type[str];
        
        if (index == 0) {
            normal += menu[index][str];
            total += menu[index][str];
        }

        
        else if (index == 1) {
            num_special++;
            total += menu[index][str];
        }

        
        else if (index == 2) {
            num_service++;
        }
    }

    bool ans = true;
    // check
    if (num_special && normal < 20000 ) ans = false;
    if (num_service > 1) ans = false;
    if (num_service == 1 && total < 50000) ans = false;

    cout << (ans ? "Okay" : "No");
    return 0;
}