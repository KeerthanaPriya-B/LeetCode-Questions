//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		
		if(s.size() > 0) {
		    
		    int a = s.peek();
		    s.pop();
		    sort(s);
		    
		    insert_in_order(s, a);
		}
		
		return s;
	}
	public Stack<Integer> insert_in_order(Stack<Integer> s, int a) {
	    
	    if(s.isEmpty() || s.peek()<a){
	        s.push(a);
	        return s;
	    }
	    int x = s.peek();
	    s.pop();
	    insert_in_order(s, a);
	    
	    s.push(x);
	    return s;
	}
	
}