class Solution {
    public String minWindow(String s, String t) {
     
        //recording: 26th june Hashing 4 time(1:45:00)
		//TC: O(N)  SC: O(26)~O(1)

		//in hashmap if the key is Character i.e alphabets,
		//SC: O(26) which is approxi O(1)
		HashMap<Character, Integer> fmapT = new HashMap<>();
		for(char ch: t.toCharArray())
			fmapT.put(ch, fmapT.getOrDefault(ch, 0) + 1);

		int inc = -1;
		int exc = -1;
		
		int dmcnt = t.length();
		int mcnt = 0;

		HashMap<Character, Integer> fmapS = new HashMap<>();
		String ans = "";
	
		while(true){
			boolean f1 = false, f2 = false;
			
			//inc	
			if (inc+1 < s.length() && dmcnt > mcnt) {
				inc++;
				char ch = s.charAt(inc);

				if(fmapT.containsKey(ch)) {
					if(fmapS.getOrDefault(ch, 0) < fmapT.get(ch))
						//increase mcnt, as this char is important
						mcnt++;
				}
				fmapS.put(ch, fmapS.getOrDefault(ch, 0) + 1);

				f1 = true;
			}	
			//exc
			else if (exc < inc && dmcnt == mcnt) {
				String pans = s.substring(exc+1, inc+1);

				if(ans.equals("") || ans.length() > pans.length()) 
					ans = pans;

				exc++;
				char c = s.charAt(exc);
				if(fmapT.containsKey(c)) {
					//reduce mcnt, as we are excluding important char
					if(fmapS.get(c) <= fmapT.get(c))
						mcnt--;
				}
				fmapS.put(c, fmapS.get(c) - 1);
				if(fmapS.get(c) == 0)
					fmapS.remove(c);

				f2 = true;
			}

			//when inc & exc both the operation didn't happen, 
			//we can end the loop
			if(f1 == false && f2 == false)
				break;
		}
		return ans;
    }
}