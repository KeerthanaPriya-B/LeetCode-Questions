class Solution {
    public List<List<String>> groupAnagrams(String[] wordArr) {
        
        
        //recording: 26th june Hashing 4 time(30:00:00)
        //TC: O(N*M)  SC: O(N)
        
        HashMap<String, List<String>> groups = new HashMap<>();
		List<List<String>> res = new ArrayList<>();

		//TC: O(N)
		for(String wrd: wordArr) {
			
			//TC: O(M)
			String code = generateCode(wrd);

			if(groups.containsKey(code)) {
				List<String> list = groups.get(code);
				list.add(wrd);
				groups.put(code, list);
			}
			else {
				List<String> list = new ArrayList<>();
				list.add(wrd);
				groups.put(code, list);
			}
		}
        for(String code: groups.keySet()) {
            List<String> list = groups.get(code);
            res.add(list);   
        }
        return res;
    }
    
    public String generateCode(String wrd) {

		int[] freqArr = new int[26];

		for(char ch: wrd.toCharArray()) 
			freqArr[ch - 'a']++;

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			if(freqArr[i] > 0) {
				sb.append((char)('a' + i));
				sb.append(freqArr[i]);
			}
		}
		return sb.toString();
	}
}