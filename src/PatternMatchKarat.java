public boolean patternMatch(String words, String pattern) {
		 Map<Character,Integer> patternMap = new HashMap<>();
		 Map<Character,Integer> wordcount = new HashMap<>();
		 for(char c:pattern.toCharArray()) {
			 patternMap.put(c,patternMap.getOrDefault(c, 0)+1);
		 }
		 for(char c: words.toCharArray()) {
			 wordcount.put(c,wordcount.getOrDefault(c, 0)+1);
		 }
		 for(Map.Entry<Character, Integer> k:wordcount.entrySet()) {
			 if(!patternMap.containsKey(k.getKey())||k.getValue()!= patternMap.get(k.getKey())) {
				 return false;
			 }
		 }
		 return true;
	 }

/**
String[] words = {"cat", dada", breath" , "taking", "doll"}
String pattern = "drctkla"
String pattern = "rdatlbohe"

Answer - cat
Answer - breath
*/
