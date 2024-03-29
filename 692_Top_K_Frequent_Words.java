class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        List<String> can = new ArrayList<>(map.keySet());
        Collections.sort(can,(w1,w2)->map.get(w1)==map.get(w2)?w1.compareTo(w2):map.get(w2)-                                     map.get(w1));
        return can.subList(0,k);
    }
}


/**
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

*/
