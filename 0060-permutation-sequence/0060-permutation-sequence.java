class Solution {
    public String getPermutation(int n, int k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        String res = "";
        k -= 1;
        int fact=1;
        
        for(int i=1; i<n; i++)
        {
            fact *= i;
            arr.add(i);
        }
        arr.add(n);
        
        while(true)
        {
            res += arr.get(k/fact);
            arr.remove(k/fact);
            
            if(arr.size() == 0) break;
            
            k %= fact;
            fact /= arr.size();
        }
        
        return res;
    }
//     public String getPermutation(int n, int k) {
        
//         ArrayList<String> res = new ArrayList<>();
//         String str ="";
//         for(int i=1; i<=n; i++){
//             str += i;
//         }
        
//         permutation(str.toCharArray(), 0, res);
//         Collections.sort(res);
//         return res.get(k-1);
//     }
    
//     static void permutation(char[] ch, int fi, ArrayList<String> res){
        
//         if(fi == ch.length){
//             res.add(new String(ch));
//             return;
//         }
        
//         for(int i=fi; i<ch.length; i++){
//             swap(ch, i ,fi);
//             permutation(ch, fi+1, res);
//             swap(ch, i ,fi);
//         }
//     }
    
//     static void swap(char[] ch, int i, int fi){
//         char temp = ch[i];
//         ch[i] = ch[fi];
//         ch[fi] = temp;
//     }
}