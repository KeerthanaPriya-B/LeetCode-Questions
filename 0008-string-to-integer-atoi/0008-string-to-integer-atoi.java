class Solution {
    public int myAtoi(String s) { 
        int i = 0, n = s.length(), sign = 1;;
        
        while(i < n && s.charAt(i) == ' ')
            i++;
        
        if(i == n) return 0;
        
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }
        
        if(i == n) return 0;
        
        int num = 0, maxVal = Integer.MAX_VALUE, minVal = Integer.MIN_VALUE;
        
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') 
        {
            int digit = s.charAt(i) - '0';
            
            if(num > maxVal/10 || (num == maxVal/10 && digit > maxVal%10))
                return (sign == 1) ? maxVal : minVal;
            
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}







