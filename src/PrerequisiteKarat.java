public String courseScheduling(String[][] input) {
		String res = null;
		String start = null;
		Map<String,String> map = new HashMap<>();
		for(int i=0;i<input.length;i++) {
				map.put(input[i][0], input[i][1]);
		}
		List<String> list = new ArrayList<>();
		List<String> outputList = new ArrayList<>();
		for(Map.Entry<String, String> map1:map.entrySet()) {
			list.add(map1.getValue());
		}
		for(Map.Entry<String, String> map1:map.entrySet()) {
			if(!list.contains(map1.getKey())) {
				start = map1.getKey();
				break;
			}
		}
		outputList.add(start);
		while(outputList.size()<map.size()) {
			start = map.get(start);
			outputList.add(start);
			
		}
		
		return outputList.get(outputList.size()/2);
	}

String[][] input1= {
				{"Foundations of Computer Science", "Operating Systems"},
{"Data Structures", "Algorithms"},
{"Computer Networks", "Computer Architecture"},
{"Algorithms", "Foundations of Computer Science"},
{"Computer Architecture", "Data Structures"},
{"Software Design", "Computer Networks"}
};

System.out.println(k.courseScheduling(input1));

/**
You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
pairs1 = [
["Foundations of Computer Science", "Operating Systems"],
["Data Structures", "Algorithms"],
["Computer Networks", "Computer Architecture"],
["Algorithms", "Foundations of Computer Science"],
["Computer Architecture", "Data Structures"],
["Software Design", "Computer Networks"]
]

In this case, the order of the courses in the program is:
Software Design
Computer Networks
Computer Architecture
Data Structures
Algorithms
Foundations of Computer Science
Operating Systems

Sample output 1:
"Data Structures"

Sample input 2:
pairs2 = [
["Algorithms", "Foundations of Computer Science"],
["Data Structures", "Algorithms"],
["Foundations of Computer Science", "Logic"],
["Logic", "Compilers"],
["Compilers", "Distributed Systems"],
]

Sample output 2:
"Foundations of Computer Science"

Sample input 3:
pairs3 = [
["Data Structures", "Algorithms"],
]

Sample output 3:
"Data Structures"

All Test Cases:
halfway_course(pairs1) => "Data Structures"
halfway_course(pairs2) => "Foundations of Computer Science"
halfway_course(pairs3) => "Data Structures"
*/
