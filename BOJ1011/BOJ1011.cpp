#include <iostream>
#include <cmath>

using namespace std;

int main() {

    // I/O speed management
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
        
    int T; // test case
    cin >> T;

    for (int i = 0; i < T; i++) {

        int x, y;
        cin >> x >> y; // current location, wannabe location

        int distance = y - x;

        /*
            1, 2, 3 -> 1, 2, 3

            4 -> 1 2 1
            6 -> 1 2 2 1
            9 -> 1 2 3 2 1
            12 -> 1 2 3 3 2 1
            16 -> 1 2 3 4 3 2 1
            20 -> 1 2 3 4 4 3 2 1
            25 -> 1 2 3 4 5 4 3 2 1
            Thus, Number X : X^2 -> X^2 + X -> (X+1)^2 
        */


        int doubleNum = (int)sqrt(distance); // Power Number

        // Originally first try, start the number '2' and execute Loop,
        // but because of time over, 
        // using 'sqrt' to find "Power Number"

        int opNum = doubleNum * 2 - 1; // Operated number


        // 1 2 3 exception handling
        if (distance <= 3) {
            cout << distance << "\n";
            continue;
        }

        
        if (doubleNum * doubleNum >= distance) {
            cout << opNum << "\n";
            continue;
        }

        opNum++;

        if (doubleNum * doubleNum + doubleNum >= distance) {
            cout << opNum << "\n";
            continue;
        }
        else {
            cout << opNum + 1 << "\n";
            continue;
        }
    }

    return 0;
}
