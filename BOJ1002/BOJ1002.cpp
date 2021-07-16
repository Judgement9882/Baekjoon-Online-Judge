#define _USE_MATH_DEFINES

#include <iostream>
#include <cmath>

using namespace std;

int main() {

    // I/O speed management
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N; // test case

    for (int i = 0; i < N; i++) {
        // input
        int x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1;
        cin >> x2 >> y2 >> r2;

        // if they are same -> inf -> print -1
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            cout << -1 << "\n";
            continue;
        }

        // distance between x and y
        float distance = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        // case :  circle, in the another circle
        // r1 > r2
        if ((r1 > r2) && ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) < r1 * r1)) {

            // r1 - r2 < distance
            if (r1 - r2 < distance) {
                cout << 2 << "\n";
            }
            else if (r1 - r2 == distance) {
                cout << 1 << "\n";
            }
            else {
                cout << 0 << "\n";
            }
        }
        // r1 < r2
        else if ((r1 < r2) && ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < r2 * r2)) {
            // r2 - r1 < distance
            if (r2 - r1 < distance) {
                cout << 2 << "\n";
            }
            else if (r2 - r1 == distance) {
                cout << 1 << "\n";
            }
            else {
                cout << 0 << "\n";
            }
        }

        // circle, the outside of another circle

        else if (r1 + r2 > distance) {
            cout << 2 << "\n";
        }

        // if circles match only one point
        else if (r1 + r2 == distance) {
            cout << 1 << "\n";
        }

        // the point is out of two circles
        else {
            cout << 0 << "\n";
        }
    }


    return 0;
}