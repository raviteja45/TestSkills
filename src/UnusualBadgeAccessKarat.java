public List<List<String>> unusualBadgeAccess(String[][] input){
    	List<List<String>> res = new ArrayList<>();
    	Map<String,List<String>> map = new HashMap<>();
    	for(int i=0;i<input.length;i++) {
    		if(map.containsKey(input[i][0])) {
    			List<String> li = map.get(input[i][0]);
    			li.add(input[i][1]);
    			map.replace(input[i][0], li);
    		}else {
    			List<String> li = new ArrayList<>();
    			li.add(input[i][1]);
    			map.put(input[i][0], li);
    		}
    	}
    	
    	for(Map.Entry<String, List<String>> map1: map.entrySet()) {
    		List<String> list = map1.getValue();
    		Collections.sort(list,(a,b)->Integer.valueOf(a)-Integer.valueOf(b));
    		for(int i =2;i<list.size();i++){
                int c = Integer.valueOf(list.get(i));
                int p = Integer.valueOf(list.get(i-2));
                if(c-p<=100){
                    List<String> res1 = new ArrayList<String>();
                    res1.add(map1.getKey());
                    for(int j=i-2;j<list.size(); j++) {
                        int k = Integer.valueOf(list.get(j));
                        if(k-p<=100) {
                            res1.add(list.get(j));
                        } else {
                            break;
                        }
                    }
                    res.add(res1);
                    break;
                }
            }
    	}
    	return res;
    }


String[][] input7 = {
			
			{"Paul", "1355"},
            {"Jennifer", "1910"},
			{"Jose", "835"},
			{"Jose", "830"},
			{"Paul", "1315"},
			{"Chloe", "0"},
			{"Chloe", "1910"},
			{"Jose", "1615"},
			{"Jose", "1640"},
			{"Paul", "1405"},
			{"Jose", "855"},
            {"Jose", "930"},
			{"Jose", "915"},
			{"Jose", "730"},
			{"Jose", "940"},
			{"Jennifer", "1335"},
			{"Jennifer", "730"},
			{"Jose", "1630"},
			{"Jennifer", "5"},
			{"Chloe", "1909"},
			{"Zhang", "1"},
			{"Zhang", "10"},
			{"Zhang", "109"},
			{"Zhang", "110"},
			{"Amos", "1"},
			{"Amos", "2"},
			{"Amos", "400"},
			{"Amos", "500"},
			{"Amos", "503"},
			{"Amos", "504"},
			{"Amos", "601"},
			{"Amos", "602"},
			{"Paul", "1416"}
			             };
	
	System.out.println( k.unusualBadgeAccess(input7));

/**
We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
["Paul", "1355"], ["Jennifer", "1910"], ["Jose", "835"],
["Jose", "830"], ["Paul", "1315"], ["Chloe", "0"],
["Chloe", "1910"], ["Jose", "1615"], ["Jose", "1640"],
["Paul", "1405"], ["Jose", "855"], ["Jose", "930"],
["Jose", "915"], ["Jose", "730"], ["Jose", "940"],
["Jennifer", "1335"], ["Jennifer", "730"], ["Jose", "1630"],
["Jennifer", "5"], ["Chloe", "1909"], ["Zhang", "1"],
["Zhang", "10"], ["Zhang", "109"], ["Zhang", "110"],
["Amos", "1"], ["Amos", "2"], ["Amos", "400"],
["Amos", "500"], ["Amos", "503"], ["Amos", "504"],
["Amos", "601"], ["Amos", "602"], ["Paul", "1416"],
];

Expected output (in any order)
Paul: 1315 1355 1405
Jose: 830 835 855 915 930
Zhang: 10 109 110
Amos: 500 503 504

n: length of the badge records array
'''

badge_records = [
["Paul", "1355"],
["Jennifer", "1910"],
["Jose", "835"],
["Jose", "830"],
["Paul", "1315"],
["Chloe", "0"],
["Chloe", "1910"],
["Jose", "1615"],
["Jose", "1640"],
["Paul", "1405"],
["Jose", "855"],
["Jose", "930"],
["Jose", "915"],
["Jose", "730"],
["Jose", "940"],
["Jennifer", "1335"],
["Jennifer", "730"],
["Jose", "1630"],
["Jennifer", "5"],
["Chloe", "1909"],
["Zhang", "1"],
["Zhang", "10"],
["Zhang", "109"],
["Zhang", "110"],
["Amos", "1"],
["Amos", "2"],
["Amos", "400"],
["Amos", "500"],
["Amos", "503"],
["Amos", "504"],
["Amos", "601"],
["Amos", "602"],
["Paul", "1416"],
]
*/
