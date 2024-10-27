#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

string EOI = "EOI";

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    unordered_map<string, double> item;
    item.insert({ "Paper", 57.99 });
    item.insert({ "Printer", 120.50 });
    item.insert({ "Planners", 31.25 });
    item.insert({ "Binders", 22.50 });
    item.insert({ "Calendar", 10.95 });
    item.insert({ "Notebooks", 11.20 });
    item.insert({ "Ink", 66.95 });

    double ans = 0.0;
    while (true) {
        string str;
        cin >> str;
        if (str == EOI) break;
        ans += item[str];
    }

    cout << fixed;
    cout.precision(2);

    cout << "$" << ans;

    return 0;
}