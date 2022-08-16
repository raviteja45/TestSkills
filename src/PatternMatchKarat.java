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

words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax"]
String string1 = "ctay";
String string2 = "bcanihjsrrrferet";
String string3 = "tbaykkjlga";
String string4 = "bbbblkkjbaby";
String string5 = "dad";
String string6 = "breadmaking";

string1 = "ctay"
find(words, string1) => "cat" (the letters do not have to be in order)

string2 = "bcanihjsrrrferet"
find(words, string2) => "cat" (the letters do not have to be together)

string3 = "tbaykkjlga"
find(words, string3) => "-" (the letters cannot be reused)

*/
