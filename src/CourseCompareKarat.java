import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Karat {

	public static void main(String[] args) {
		Karat k = new Karat();
		String[][] input = {
			{"58", "Linear Algebra"},
			{"94", "Art History"},
			{"94", "Operating Systems"},
			{"17", "Software Design"},
			{"58", "Mechanics"},
			{"58", "Economics"},
	        {"17", "Linear Algebra"},
            {"17", "Political Science"},
            {"94", "Economics"},
            {"25", "Economics"},
            {"58", "Software Design"}
			};
		System.out.println(k.courseSchedule(input));

	}
	
	public List<String> courseSchedule(String[][] input){
		List<String> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		Map<String,Set<String>> map = new HashMap<>();
		for(int i=0;i<input.length;i++) {
				if(map.containsKey(input[i][0])) {
					Set<String> set = map.get(input[i][0]);
					set.add(input[i][1]);
					map.replace(input[i][0], set);
				}else {
					Set<String> set = new HashSet<>();
				  set.add(input[i][1]);
					map.put(input[i][0], set);
				}
		}
		for(Map.Entry<String, Set<String>> map1: map.entrySet()) {
			for(Map.Entry<String, Set<String>> map2: map.entrySet()) {
				if(map1.getKey().equals(map2.getKey())) {
					continue;
				}
				if(temp.contains(map1.getKey()+","+map2.getKey())||temp.contains(map2.getKey()+","+map1.getKey())) {
					continue;
				}
				StringBuilder sb = new StringBuilder();
				sb.append(map1.getKey()+","+map2.getKey());
				temp.add(sb.toString());
				temp.add(map2.getKey()+","+map1.getKey());
				sb.append(":");
				int j = 0;
				Set<String> s1 = new HashSet<>(map1.getValue());
				s1.retainAll(map2.getValue());
				if(s1.size()==0) {
					sb.append("[");
					sb.append(" ");
				}else {
					for(String x:s1) {
						if(!sb.toString().contains("[")) {
							sb.append("[");
						}
						sb.append(x);
						if(j!=s1.size()-1) {
							sb.append(",");
						}
						j++;
					}
				}
				
				sb.append("]");
				res.add(sb.toString());
			}
		}
		
		return res;
	}
//[58,25:[Economics], 58,17:[Software Design,Linear Algebra], 58,94:[Economics], 25,17:[ ], 25,94:[Economics], 17,94:[ ]]
}

/**
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students, a collection of all courses they share.


Sample Input:

enrollments1 = {
  "58": "Linear Algebra",
  "94": "Art History",
  "94": "Operating Systems",
  "17": "Software Design",
  "58": "Mechanics",
  "58": "Economics",
  "17": "Linear Algebra",
  "17": "Political Science",
  "94": "Economics",
  "25": "Economics",
  "58": "Software Design"
}

Sample Output (pseudocode, in any order):

find_pairs(enrollments1) =>
{
  "58,17": ["Software Design", "Linear Algebra"]
  "58,94": ["Economics"]
  "58,25": ["Economics"]
  "94,25": ["Economics"]
  "17,94": []
  "17,25": []
}
*/
