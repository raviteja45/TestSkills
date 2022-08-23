public List<String> resourceAccessLog(String[][] input) {
		Map<String,List<Integer>> map = new HashMap<>();
		List<String> res = new ArrayList<>();
		for(int i=0;i<input.length;i++) {
			if(map.containsKey(input[i][1])) {
				List<Integer> li = map.get(input[i][1]);
				li.add(Integer.parseInt(input[i][0]));
				map.replace(input[i][1],li );
			}else {
				List<Integer> li = new ArrayList<>();
				li.add(Integer.parseInt(input[i][0]));
				map.put(input[i][1], li);
			}
		}
		
		for(Map.Entry<String, List<Integer>> temp:map.entrySet()) {
			Collections.sort(temp.getValue());
			res.add(temp.getKey()+":["+temp.getValue().get(0)+","+temp.getValue().get(temp.getValue().size()-1)+"]");
		}
		return res;
	}

/**
String[][] input9  = {
            {"58523", "user_1", "resource_1"},
            {"62314", "user_2", "resource_2"},
            {"54001", "user_1", "resource_3"},
            {"200", "user_6", "resource_5"},
            {"215", "user_6", "resource_4"},
            {"54060", "user_2", "resource_3"},
            {"53760", "user_3", "resource_3"},
            {"58522", "user_22", "resource_1"},
            {"53651", "user_5", "resource_3"},
            {"2", "user_6", "resource_1"},
            {"100", "user_6", "resource_6"},
            {"400", "user_7", "resource_2"},
            {"100", "user_8", "resource_6"},
            {"54359", "user_1", "resource_3"},
    };
	
	System.out.println(k.resourceAccessLog(input9));
  
  Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
For example:
logs1 = [
["58523", "user_1", "resource_1"],
["62314", "user_2", "resource_2"],
["54001", "user_1", "resource_3"],
["200", "user_6", "resource_5"],
["215", "user_6", "resource_4"],
["54060", "user_2", "resource_3"],
["53760", "user_3", "resource_3"],
["58522", "user_22", "resource_1"],
["53651", "user_5", "resource_3"],
["2", "user_6", "resource_1"],
["100", "user_6", "resource_6"],
["400", "user_7", "resource_2"],
["100", "user_8", "resource_6"],
["54359", "user_1", "resource_3"],
]
Example 2:
logs2 = [
["300", "user_1", "resource_3"],
["599", "user_1", "resource_3"],
["900", "user_1", "resource_3"],
["1199", "user_1", "resource_3"],
["1200", "user_1", "resource_3"],
["1201", "user_1", "resource_3"],
["1202", "user_1", "resource_3"]
]
Question 1 - Write a function that takes the logs and returns each users min and max access timestamp
Example Output:
user_3:[53760,53760]
user_2:[54060,62314]
user_1:[54001,58523]
user_7:[400,400]
user_6:[2,215]
user_5:[53651,53651]
user_4:[58522,58522]
user_8:[100,100]

*/
