public List<String> findWordsInArray(char[][] input,String word) {
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				if(input[i][j]==word.charAt(0)) {
					List<String> res = new ArrayList<>();
					if(backTracking(input,word,res,0,i,j))
					return res;
				}
			}
		}

		return new ArrayList<>();
	}
	
	public boolean backTracking(char[][] input, String word, List<String> res, int index,int i,int j) {
		if(index==word.length()) {
			return true;
		}
		if(i<0||j<0||i>=input.length||j>=input[0].length||input[i][j]!=word.charAt(index)) {
			return false;
		}
		res.add(i+","+j);
		return backTracking(input,word,res,index+1,i+1,j) || backTracking(input,word,res,index+1,i,j+1);
	}


/**
Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
['c', 'c', 't', 'n', 'a', 'x'],
['c', 'c', 'a', 't', 'n', 't'],
['a', 'c', 'n', 'n', 't', 't'],
['t', 'n', 'i', 'i', 'p', 'p'],
['a', 'o', 'o', 'o', 'a', 'a'],
['s', 'a', 'a', 'a', 'o', 'o'],
['k', 'a', 'i', 'o', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "ant"
word5 = "aoi"
word6 = "ki"
word7 = "aaoo"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
[(0, 0), (1, 0), (1, 1), (2, 1)]
OR [(0, 0), (0, 1), (1, 1), (2, 1)]
find_word_location(grid1, word3) => [(5, 0)]
find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]
*/
