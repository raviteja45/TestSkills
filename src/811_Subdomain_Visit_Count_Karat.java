class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String x:cpdomains){
            String[] temp = x.split(" ");
            int count = Integer.parseInt(temp[0]);
            String[] temp1 = temp[1].split("\\.");
            if(temp1.length==3){
                temp1[0] = temp1[0]+"."+temp1[1]+"."+temp1[2];
                temp1[1] = temp1[1]+"."+temp1[2];
            }
            if(temp1.length==2){
                temp1[0] = temp1[0]+"."+temp1[1];
            }
            for(String x1:temp1){
                if(map.containsKey(x1)){
                    map.put(x1,map.get(x1)+count);
                }else{
                    map.put(x1,count);
                }
            }
        }
        for(String key:map.keySet()){
            res.add(String.valueOf(map.get(key))+" "+key);
        }
        return res;
    }
}


/**
A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.

 

Example 1:

Input: cpdomains = ["9001 discuss.leetcode.com"]
Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
Explanation: We only have one website domain: "discuss.leetcode.com".
As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
Example 2:

Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
*/
