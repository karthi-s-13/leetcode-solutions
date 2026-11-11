# 208. Implement Trie (Prefix Tree)

### Difficulty: Medium

## Description
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:


	Trie() Initializes the trie object.
	void insert(String word) Inserts the string word into the trie.
	boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
	boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


 
Example 1:


Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


 
Constraints:


	1 <= word.length, prefix.length <= 2000
	word and prefix consist only of lowercase English letters.
	At most 3 * 104 calls in total will be made to insert, search, and startsWith.

## Submission Details
- **Status**: Accepted
- **Runtime**: 39
- **Memory**: 61312000
- **Language**: java

## Code
```java
class Trie {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = help(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return help(prefix) != null;
    }
    public TrieNode help(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null){
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```
