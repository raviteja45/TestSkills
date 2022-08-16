 public List<String> continuousArray(String[] user1, String[] user2){
    	List<String> res = new ArrayList<>();
    	int maxLength = 0;
    	int start = 0;
    	int[][] dp = new int[user1.length+1][user2.length+1];
    	for(int i=1;i<user1.length+1;i++) {
    		for(int j=1;j<user2.length+1;j++) {
    			if(user1[i-1]==user2[j-1]) {
    				dp[i][j] = dp[i-1][j-1]+1;
    			}
    			if(dp[i][j]>maxLength) {
    				maxLength = dp[i][j];
    				start = i-1;
    			}
    		}
    	}
    	System.out.println("Max "+maxLength+" start "+start);
    	for(int i=start-maxLength+1;i<start+1;i++) {
    		res.add(user1[i]);
    	}
    	return res;
    }

/**
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/CornflowerBlue", "/LightGoldenRodYellow", ]
user4 = ["/pink", "/orange", "/amber", "/plum", "/blue", "/tan", "/red", "/lavender", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]

Sample output:

findLongestHistory(user0, user1) => ["/pink", "/register", "/orange"]
findLongestHistory(user0, user2) => [] (empty)
findLongestHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
findLongestHistory(user5, user2) => ["a"]
findLongestHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findLongestHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
*/
