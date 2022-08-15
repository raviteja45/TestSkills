public List<Set<String>> badgeAccess(String[][] input){
		Set<String> entryList = new HashSet<>();
		Set<String> exitList = new HashSet<>();
		Set<String> reEntryList = new HashSet<>();
		List<Set<String>> res = new ArrayList<>();
		for(int i=0;i<input.length;i++) {
			if(input[i][1].equals("enter")) {
				if(entryList.contains(input[i][0])) {
					reEntryList.add(input[i][0]);
				}else {
					entryList.add(input[i][0]);
				}
			}
			if(input[i][1].equals("exit")) {
				if(entryList.contains(input[i][0])) {
					entryList.remove(input[i][0]);
				}else {
					exitList.add(input[i][0]);
				}
			}
		}
		entryList.addAll(reEntryList);
		res.add(entryList);
		res.add(exitList);
		return res;
	}


/**
Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

records1 = [
["Martha", "exit"],
["Paul", "enter"],
["Martha", "enter"],
["Steve", "enter"],
["Martha", "exit"],
["Jennifer", "enter"],
["Paul", "enter"],
["Curtis", "exit"],
["Curtis", "enter"],
["Paul", "exit"],
["Martha", "enter"],
["Martha", "exit"],
["Jennifer", "exit"],
["Paul", "enter"],
["Paul", "enter"],
["Martha", "exit"],
["Paul", "enter"],
["Paul", "enter"],
["Paul", "exit"],
["Paul", "exit"]
]

Expected output: ["Paul", "Curtis", "Steve"], ["Martha", "Curtis", "Paul"]

Other test cases:

records2 = [
["Paul", "enter"],
["Paul", "exit"],
]

Expected output: [], []

records3 = [
["Paul", "enter"],
["Paul", "enter"],
["Paul", "exit"],
["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

records4 = [
["Paul", "enter"],
["Paul", "exit"],
["Paul", "exit"],
["Paul", "enter"],
]

Expected output: ["Paul"], ["Paul"]
*/
