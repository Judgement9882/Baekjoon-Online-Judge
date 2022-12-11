#include <iostream>

using namespace std;

int main() {
  
  int balance;
  char op;
  int amount;

  
  while (cin >> balance >> op >> amount && !(balance == 0 && op == 'W' && amount == 0)) {
    if (op == 'W') {
      balance -= amount;
    } else {
      balance += amount;
    }

    if (balance < -200) {
      cout << "Not allowed" << endl;
    } else {
      cout << balance << endl;
    }
  }

  return 0;
}