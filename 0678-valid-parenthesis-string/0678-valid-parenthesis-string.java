class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> open = new Stack<>();
		Stack<Integer> star = new Stack<>();
        int n = s.length();

		for(int i=0; i<n; i++){
			char ch = s.charAt(i);

			if(ch == '(') 
				open.push(i);
			else if(ch == '*')
				star.push(i);
			else{
				if(!open.isEmpty())  open.pop();
				else if(!star.isEmpty())  star.pop();
				else  return false;
			} 
		}

		while(!open.isEmpty()){
			if(!star.isEmpty()) 
			{
				if(open.pop()<star.pop())  continue;
				else  return false; 
			} 
			else  return false;
		}
		return true;
    }
}