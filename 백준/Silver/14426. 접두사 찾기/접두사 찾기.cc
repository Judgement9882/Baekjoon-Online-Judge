#include <iostream>

using namespace std;

class Node {
public:
	Node* childs[26] = { NULL };
	bool fin = false;
	Node() {}
};
	
class Trie {
public:
	Node* root;
	Trie() { this->root = new Node(); }
	
	void insert(string str) {
		Node* cur = this->root;
		for (int i = 0; i < str.length(); i++) {
			int idx = str[i] - 'a';
			if (cur->childs[idx] != NULL)
				cur = cur->childs[idx];
			else {
				cur->childs[idx] = new Node();
				cur = cur->childs[idx];
				cur->fin = true;
			}
		}

		cur->fin = true;
	}

	bool find(string str) {
		Node* cur = this->root;
		for (int i = 0; i < str.length(); i++) {
			int idx = str[i] - 'a';
			if (cur->childs[idx] == NULL) return 0;
			else cur = cur->childs[idx];
		}

		if (cur->fin) return 1;
		return 0;
	}
};


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
		
	Trie* trie = new Trie();

	int N, M; cin >> N >> M;
	while (N--) {
		string str;
		cin >> str;
		trie->insert(str);
	}
	
	int ans = 0;
	while (M--) {
		string str;
		cin >> str;
		if (trie->find(str)) ans++;
	}
	
	cout << ans;

	delete(trie);

	return 0;
}