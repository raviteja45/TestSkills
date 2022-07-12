class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> freq_count;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        freq_count = new HashMap<>();
    }
    
    public void push(int val) {
        int x = freq.getOrDefault(val,0)+1;
        freq.put(val,x);
        if(!freq_count.containsKey(x)){
            freq_count.put(x,new Stack<>());
        }
         Stack<Integer> temp = freq_count.get(x);
        temp.add(val);
        freq_count.put(x,temp);
         maxFreq = Math.max(maxFreq,x);
        System.out.println("Push - freq "+freq);
        System.out.println("Push - freq_count "+freq_count);
    }
    
    public int pop() {
        Stack<Integer> temp = freq_count.get(maxFreq);
        int h = temp.pop();
        freq.put(h,maxFreq-1);
        if(freq_count.get(maxFreq).size()==0){
            maxFreq--;
        }
        System.out.println("Pop - freq "+freq);
        System.out.println("Pop - freq_count "+freq_count);
        return h;
        
    }
}


Push - freq {5=1}
Push - freq_count {1=[5]}
Push - freq {5=1, 7=1}
Push - freq_count {1=[5, 7]}
Push - freq {5=2, 7=1}
Push - freq_count {1=[5, 7], 2=[5]}
Push - freq {5=2, 7=2}
Push - freq_count {1=[5, 7], 2=[5, 7]}
Push - freq {4=1, 5=2, 7=2}
Push - freq_count {1=[5, 7, 4], 2=[5, 7]}
Push - freq {4=1, 5=3, 7=2}
Push - freq_count {1=[5, 7, 4], 2=[5, 7], 3=[5]}
Pop - freq {4=1, 5=2, 7=2}
Pop - freq_count {1=[5, 7, 4], 2=[5, 7], 3=[]}
Pop - freq {4=1, 5=2, 7=1}
Pop - freq_count {1=[5, 7, 4], 2=[5], 3=[]}
Pop - freq {4=1, 5=1, 7=1}
Pop - freq_count {1=[5, 7, 4], 2=[], 3=[]}
Pop - freq {4=0, 5=1, 7=1}
Pop - freq_count {1=[5, 7], 2=[], 3=[]}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */


/**
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
*/
