//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    int mini;
    GfG(){
        this.mini = Integer.MAX_VALUE;
    }
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(s.isEmpty()) {
	        s.push(a);
	        mini = a;
	    }
	    else if(a >= mini)  
	        s.push(a);
	    else {
	        s.push(2*a - mini);
	        mini = a;
	    }
	    
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
        
    	    if(s.peek() >= mini) 
    	        return s.pop();
    	        
    	    else if(s.peek() < mini) {
    	        mini = 2*mini - s.peek();
    	        return s.pop();
    	    }
            return -1; 
            
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return mini;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size()==n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.isEmpty();
	}
}