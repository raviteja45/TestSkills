class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words_dict = new HashSet<>(wordList);
        Queue<String> all_possible = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        all_possible.add(beginWord);
        isVisited.add(beginWord);
        int count = 1;
        while(!all_possible.isEmpty()){ // Its like BFS.
            int n = all_possible.size();
            for(int i=0;i<n;i++){
                String s = all_possible.poll();
                if(s.equals(endWord)){
                    return count;
                }
                for(int j=0;j<s.length();j++){
                    for(char c = 'a';c<='z';c++){
                        char[] temp = s.toCharArray();
                        temp[j] = c;// Checking all possibilities
                        String newTemp = new String(temp);
                        if(words_dict.contains(newTemp)&&!isVisited.contains(newTemp)){
                            isVisited.add(newTemp);
                            all_possible.add(newTemp);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}


/**
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

*/
