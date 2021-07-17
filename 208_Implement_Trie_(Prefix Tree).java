package com.att.idp.catalog.wireless.controller;

import java.util.HashMap;
import java.util.Map;

class Trie {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("apple");
		System.out.println(t.search("apple"));
		t.insert("Orange");
	}
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(Character ch: word.toCharArray()){
            Map<Character,Node> c = node.children;
            if(!c.containsKey(ch)){
                c.put(ch,new Node());
            }
            node = c.get(ch);
        }
        node.exists = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node =  root;
        for(Character ch:word.toCharArray()){
            Map<Character,Node> map = node.children;
            if(!map.containsKey(ch)){
                return false;
            }
            node = map.get(ch);
        }
        return node.exists;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(Character ch:prefix.toCharArray()){
            Map<Character, Node> map = node.children;
            if(!map.containsKey(ch)){
                return false;
            }
            node = map.get(ch);
        }
        return true;
    }
}

class Node{
    public boolean exists;
    public Map<Character, Node> children;
    public Node(){
        exists = false;
        children = new HashMap<>();
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**

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

*/


