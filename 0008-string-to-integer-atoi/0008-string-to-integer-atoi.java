class Solution {
    public int myAtoi(String s) { 
        int i = 0, n = s.length(), sign = 1, num = 0, maxVal = Integer.MAX_VALUE, minVal = Integer.MIN_VALUE;
        
        //for space
        while(i < n && s.charAt(i) == ' ')  i++;
        if(i == n) return 0;
        
        //for sign
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }
        if(i == n) return 0;
        
        //for integers
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9')  {
            int digit = s.charAt(i) - '0';
            
            //checking whether the num is in the limit or not
            if(num > maxVal/10 || (num == maxVal/10 && digit > maxVal%10))
                return (sign == 1) ? maxVal : minVal;
            
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}







