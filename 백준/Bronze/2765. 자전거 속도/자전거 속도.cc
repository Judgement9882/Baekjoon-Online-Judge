#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.precision(2);
    cout << fixed;
    double pi = 3.1415927;
    for(int i = 1; ; i++){
        double r, time;
        int rotate;
        cin >> r >> rotate >> time;
        if (rotate == 0) break;
        double distance = r * pi * rotate / 5280 / 12;
        cout << "Trip #" << i << ": " << distance << " " << distance / (time / 3600) << "\n";
    }
    return 0;
}