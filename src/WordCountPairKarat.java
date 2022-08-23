public String[] wordCountPair(String [] s, int wordLimit,int minwordLength) {
		Map<String,Integer> map = new HashMap<>();
		String[] res = new String[wordLimit];
		for(int i=0;i<s.length-1;i++) {
			String[] k = s[i].split(",");
				if(map.containsKey(k[0].trim())) {
					int temp = map.get(k[0].trim());
					if(temp<Integer.parseInt(k[1].trim())) {
						map.replace(k[0].trim(),Integer.parseInt(k[1].trim()));
					}
				}else {
					if(k[0].trim().length()>=minwordLength) {
						map.put(k[0].trim(), Integer.parseInt(k[1].trim()));	
					}
				}
		}
		Queue<Map.Entry<String,Integer>> q = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
		for(Map.Entry<String, Integer> m1: map.entrySet()) {
			q.add(m1);
		}
		int i=0;
		while(i<wordLimit) {
			Map.Entry<String,Integer> te = q.poll();
			String tem = te.getKey()+","+te.getValue();
			res[i] = tem;
			i++;
		}
		return res;
		
	}

/**
Given a string S containing (word,count) pair , write a function which accepts this string and returns the top words and its count sorted in descending order limited by the number of words. If the words does not meet a minumum word length then you shoud not put them in the output.


String s = new String {"abc, 500",
"sadhasjhkgdsak, 230239203",
"fsgdfssd, 78",
"sss, 56",
"ss, 56", 
"sss, 5678 
"sssdsds, 56", 
"ssssdsd, 56", }

getTopWords(String [] s, int wordLimit, minwordLength) -> (s, 3, 3)

output
 "sadhasjhkgdsak, 230239203"
 "sss, 5678 
 "abc, 500"
*/
