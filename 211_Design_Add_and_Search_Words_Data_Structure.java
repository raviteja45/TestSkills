class WordDictionary {

    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(char c:word.toCharArray()){
            Map<Character,Node> map = temp.children;
            if(!map.containsKey(c)){
                map.put(c,new Node());
            }
            temp = map.get(c);
        }
        temp.isExists = true;
        
    }
    
    public boolean search(String word) {
       return search(word,0, root);
    }
    public boolean search(String word, int index,Node curr){
       for(int i=index;i<word.length();i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                for(char c : curr.children.keySet()) {
                    Node trieNode = curr.children.get(c);
                    if(search(word,i+1,trieNode))
                        return true;
                }
                return false;
            } else {
                if(!curr.children.containsKey(ch))
                    return false;
                curr = curr.children.get(ch);
            }
        }
        return curr.isExists;
    }
}

class Node{
    Map<Character,Node> children;
    boolean isExists;
    Node(){
        children = new HashMap<>();
        isExists = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


/**
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/
