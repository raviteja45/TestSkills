class MyHashSet { // Failing some test cases.

    Node[] root = null;
    public MyHashSet() {
        root = new Node[1000000];
    }
    
    public void add(int key) {
        int has = hash(key);
        if(root[has]!=null){
            Node k = root[has];
            while(k.next!=null){
                k = k.next;
            }
            Node temp = new Node();
            temp.key = key;
            k.next = temp;
        }else{
            Node temp = new Node();
            temp.key = key;
            root[has] = temp;
        }
    }
    
    public void remove(int key) {
         int has = hash(key);
        if(root[has]!=null){
            root[has] = null;
        }
    }
    
    public boolean contains(int key) {
        int has = hash(key);
        if(root[has]!=null){
            if(root[has].key==key){
                return true;
            }
            Node y = root[has];
            while(y!=null){
                if(y.key==key){
                    return true;
                }
                y = y.next;
            }
        }else{
            return false;
        }
        return false;
    }
    
    public int hash(int key){
        int res = key*32;
        int keyVal = res%1000000;
        return keyVal;
    }
}

class Node{
    int key;
    Node next;
}
--------------------------------V2--------------------------------------------
    
class MyHashSet {

    boolean[] list = null;
    public MyHashSet() {
        list = new boolean[1000001];
    }
    
    public void add(int key) {
        list[key] = true;
    }
    
    public void remove(int key) {
        list[key] = false;
        
    }
    
    public boolean contains(int key) {
        return list[key];
    }
}

/**
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
*/
