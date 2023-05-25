/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    int n = sc.nextInt();
		    
		    System.out.println(onacci(a, b, c, n, 0));
		}
	}
	
	static int onacci(int a, int b, int c, int n, int ans){
	    
	    if(n-4 < 0)  return ans;
	    
	    ans = a+b+c;
	    return onacci(b, c, ans, n-1, ans);
	}
}