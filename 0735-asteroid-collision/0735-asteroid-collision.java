class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();

		for(int i=0; i<asteroids.length; i++){
			if(asteroids[i] > 0)
				s.push(asteroids[i]);
			else{
				while(!s.isEmpty() && s.peek()>0 && s.peek() < Math.abs(asteroids[i]))
					s.pop();

				if(!s.isEmpty() && s.peek() == Math.abs(asteroids[i]))
					s.pop();

                //if curr ele is lesser, no need to do anything 
				// if(!s.isEmpty() && s.peek() > Math.abs(asteroids[i]))
				// 	continue;
				
				else if(s.isEmpty() || s.peek()<0)
					s.push(asteroids[i]);
			}
		}
		int[] ans = new int[s.size()];
		for(int i=s.size()-1; i>=0; i--)
			ans[i] = s.pop();
		return ans;
        
        //solved on my OWN
        
//         Stack<Integer> s = new Stack<>();
        
//         for(int i=0; i<asteroids.length; i++) {
//             while(!s.isEmpty() && asteroids[s.peek()] > 0 && asteroids[i] < 0 && Math.abs(asteroids[i]) > asteroids[s.peek()]) {
//                s.pop(); 
//             }
            
//             if(!s.isEmpty() && asteroids[i] < 0  && asteroids[s.peek()] < 0)
//                 s.push(i);
//             else if(s.isEmpty() && asteroids[i] < 0 )
//                 s.push(i);
//             else if(asteroids[i] > 0)
//                 s.push(i);
//             else if(!s.isEmpty() && asteroids[s.peek()] == Math.abs(asteroids[i]))
//                 s.pop();
            
            
//         }
//         int[] a = new int[s.size()];
        
//         for(int i=a.length-1; i>=0; i--)
//             a[i] = asteroids[s.pop()];
        
//         return a;
    }
}